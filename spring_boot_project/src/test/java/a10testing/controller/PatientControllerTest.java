package a10testing.controller;



import a10testing.model.Patient;
import a10testing.security.SecurityConfig;
import a10testing.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

@Import(SecurityConfig.class)// from which secuirty info
@WebMvcTest(PatientController.class)  //whcin controller you are testing
public class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PatientService service;

     @Test
    void testGetPatientFound() throws Exception {
        Patient mockPatient = new Patient(1L, "Alice", 30);
        when(service.getPatientById(1L)).thenReturn(Optional.of(mockPatient));





//testing the controller uri
        mockMvc.perform(get("/patients/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Alice"));
    }

    @Test
    void testGetPatientNotFound() throws Exception {
        when(service.getPatientById(99L)).thenReturn(Optional.empty());
        mockMvc.perform(get("/patients/99"))
                .andExpect(status().isNotFound());
    }
}
