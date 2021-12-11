package se.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.pckg.Specialization;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization, Integer> {
}
