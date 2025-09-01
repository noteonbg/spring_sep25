package a08secfromdb.repository;



import a08secfromdb.entity.HospitalStaff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HospitalStaffRepository extends JpaRepository<HospitalStaff, String> {
    Optional<HospitalStaff> findByUsername(String username);
}

/*

show patience...

    check tale has got an entry or not... as told in the repository


 https://bcrypt-generator.com/

INSERT INTO hospital_staff (username, password, role)
VALUES ('doctor1', '$2a$10$qQyqGdDjzZJKktMbsDPr/O5f0vXXJK/XvRaTwMkZsQ0qGfrlvKgmy', 'ROLE_USER');

Password: password123


http://localhost:8080/f2
 → open to all

http://localhost:8080/f1
 → prompts for basic auth

Username: doctor1

Password: password123 (if encoded correctly)
 */
