package com.hrms.hrms.apiController.dataTransferObjects;

import lombok.Data;

@Data
public class JobPosterRegisterDto {
    
    private String email;

    private String password;

    private String passwordRepeat;
    
    private String name;

    
    private String website;

    
    private String companyEmail;

    
    private String phone;
}
