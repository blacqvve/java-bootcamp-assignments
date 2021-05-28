package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.entities.concretes.JobSeeker;
import com.hrms.hrms.entities.concretes.User;

public interface EmailConfirmationService {
    
    public String sendConfirmationMail(User user);

    public boolean validateConfirmationToken(String token, JobSeeker jobSeeker);
}
