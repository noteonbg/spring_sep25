package a10testing.basic;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // for using @BeforeAll and @AfterAll as non-static
@Tag("unit")
@DisplayName("Medical Utilities Test Suite")
class MedicalUtilsTest {

    @BeforeAll
    void initAll() {
        System.out.println(" Setting up test suite...");
    }

    @AfterAll
    void tearDownAll() {
        System.out.println(" Cleaning up after all tests...");
    }

    @BeforeEach
    void init() {
        System.out.println(" Starting a test...");
    }

    @AfterEach
    void tearDown() {
        System.out.println(" Test completed.");
    }

    @Test
    @DisplayName(" Blood pressure is normal")
    void testBloodPressureNormal() {
        assertTrue(MedicalUtils.isBloodPressureNormal(110, 70));
    }

    @Test
    @DisplayName(" Blood pressure is abnormal")
    void testBloodPressureAbnormal() {
        assertFalse(MedicalUtils.isBloodPressureNormal(130, 90));
    }

    @Test
    @DisplayName(" BMI calculation")
    void testCalculateBMI() {
        double bmi = MedicalUtils.calculateBMI(70, 1.75);
        assertEquals(22.86, bmi, 0.1);
    }

    @Test
    @DisplayName(" BMI throws exception for zero height")
    void testBMICalculationWithZeroHeight() {
        assertThrows(IllegalArgumentException.class, () -> MedicalUtils.calculateBMI(70, 0));
    }

    @Test
    @Disabled("Feature not implemented yet")
    @DisplayName(" Test for future feature")
    void testFutureFeature() {
        fail("This test is disabled");
    }

    @Nested
    @DisplayName(" Blood Pressure Parameterized Tests")
    class BloodPressureTests {

        @ParameterizedTest(name = "Test systolic: {0}")
        @ValueSource(ints = {90, 100, 120})
        void testNormalSystolicValues(int systolic) {
            assertTrue(MedicalUtils.isBloodPressureNormal(systolic, 70));
        }
    }
}

/*
| Annotation           | Purpose                                                                      |
| -------------------- | ---------------------------------------------------------------------------- |
| `@Test`              | Marks a method as a test case                                                |
| `@BeforeEach`        | Runs before each test method                                                 |
| `@AfterEach`         | Runs after each test method                                                  |
| `@BeforeAll`         | Runs once before all test methods in the class                               |
| `@AfterAll`          | Runs once after all test methods in the class                                |
| `@DisplayName`       | Custom name for test method or class                                         |
| `@Disabled`          | Temporarily disables a test                                                  |
| `@Nested`            | Groups related tests (can be hierarchical)                                   |
| `@ParameterizedTest` | Runs a test multiple times with different values                             |
| `@ValueSource`       | Supplies literal values to `@ParameterizedTest`                              |
| `@Tag`               | Used for categorizing tests (e.g., for CI pipelines)                         |
| `@TestInstance`      | Controls test instance lifecycle (used here to make `@BeforeAll` non-static) |
 */