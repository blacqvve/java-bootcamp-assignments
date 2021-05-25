package com.hrms.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="job_seekers")
public class JobSeeker extends User {
    
    @Column(name = "name")
    private String name;

    @Column(name ="surname")
    private String surname;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "national_identity_number")
    private String nationalIdentityNumber;
    
}
