package com.example.HRservice.Model;

public class Employee {

    private String id;

    private String firstname;

    private String lastname;

    private String speciality;

    public Employee() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Employee(String id, String firstname, String lastname, String speciality) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.speciality = speciality;
    }
}
