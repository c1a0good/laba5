package se.pckg;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Specialization implements Comparable<Specialization> {
    @Id
    @GeneratedValue
    private int specializationId;
    private String name;
    private boolean narrow;
    private double wageRate;
    @Transient
    private int amountOfDocs;
    @Transient
    private double costs;

    public int getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(int id) {
        this.specializationId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNarrow() {
        return narrow;
    }

    public void setNarrow(boolean narrow) {
        this.narrow = narrow;
    }

    public int getAmountOfDocs() {
        return amountOfDocs;
    }

    public void setAmountOfDocs(int amountOfDocs) {
        this.amountOfDocs = amountOfDocs;
    }

    public double getWageRate() {
        return wageRate;
    }

    public void setWageRate(double wageRate) {
        this.wageRate = wageRate;
    }

    public double getCosts() {
        return costs;
    }

    public void setCosts(double costs) {
        this.costs = costs;
    }

    public int compareTo(Specialization spec) {
        return this.name.compareTo(spec.getName());
    }
}
