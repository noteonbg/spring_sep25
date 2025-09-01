package a08secfromdb.service;




import a08secfromdb.entity.HospitalStaff;
import a08secfromdb.repository.HospitalStaffRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final HospitalStaffRepository repository;

    public CustomUserDetailsService(HospitalStaffRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("load by username in user details service");
        HospitalStaff staff = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new User(
                staff.getUsername(),
                staff.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(staff.getRole()))
        );
    }
}

