package se.pckg;

import javax.persistence.*;

@Entity
@Cacheable
public class Doctor implements Comparable<Doctor> {
    @Id
    @GeneratedValue
    private int doctorId;
    @ManyToOne
    @JoinColumn(name="specializationId")
    private Specialization specialization;
    private String lastName;
    private String firstName;
    private String middleName;
    private int birthdate;
    private int employmentDate;
    private int sectionId;
    private double salary;

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int id) {
        this.doctorId = id;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(int birthdate) {
        this.birthdate = birthdate;
    }

    public int getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(int employmentDate) {
        this.employmentDate = employmentDate;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int compareTo(Doctor doctor){
        return this.lastName.compareTo(doctor.getLastName());
    }
}
