package com.hrms.hrms.apiController.dataTransferObjects;

import java.time.LocalDate;

import lombok.Data;

@Data
public class JobSeekerRegisterDto {

    private String email;

    private String password;

    private String passwordRepeat;

    private String name;

    
    private String surname;

    
    private LocalDate dateOfBirth;

    private String nationalIdentityNumber;
}
