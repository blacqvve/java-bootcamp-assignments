package com.hrms.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name="job_seekers")
@PrimaryKeyJoinColumn(name = "user_id")
public class JobSeeker extends User {
    
    @NotBlank
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name ="surname")
    private String surname;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @NotBlank
    @Column(name = "national_identity_number")
    private String nationalIdentityNumber;
    
    @OneToOne(cascade = CascadeType.ALL)
    private EmailConfirmation emailConfirmation;
}
