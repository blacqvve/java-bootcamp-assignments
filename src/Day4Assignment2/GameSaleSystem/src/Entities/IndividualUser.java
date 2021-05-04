package Entities;

import java.time.LocalDate;

public class IndividualUser extends User {
    
    private String name;

    private String surname;

    private LocalDate dateOfBirth;

    private String nationalIdentityNumber;


    public IndividualUser(int id, String email, String name, String surname, LocalDate dateOfBirth, String nationalIdentityNumber) {
        super(id,email);
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.nationalIdentityNumber = nationalIdentityNumber;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationalIdentityNumber() {
        return this.nationalIdentityNumber;
    }

    public void setNationalIdentityNumber(String nationalIdentityNumber) {
        this.nationalIdentityNumber = nationalIdentityNumber;
    }

    public String getFullName(){
        return name + " " + surname;
    }
    @Override
    public String toString() {
        return getFullName();
    }
}
