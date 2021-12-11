package se.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.pckg.Doctor;

@Repository
public interface DoctorsRepository extends JpaRepository<Doctor, Integer> {
}
