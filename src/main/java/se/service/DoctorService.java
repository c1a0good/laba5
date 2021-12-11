package se.service;

import se.pckg.Doctor;
import se.pckg.Specialization;

import java.util.List;

public interface DoctorService {
    void create(Doctor doctor);
    List<Doctor> readAll();
    List<Doctor> readAllWithSpec(Specialization specialization);
    Doctor readById();
    void update();


}
