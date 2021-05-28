package com.hrms.hrms.business.concretes.emailConfirmation;

import java.util.UUID;

import com.hrms.hrms.business.abstracts.EmailConfirmationService;
import com.hrms.hrms.core.services.EmailService;
import com.hrms.hrms.entities.concretes.JobPoster;
import com.hrms.hrms.entities.concretes.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobPosterEmailConfirmationManager implements EmailConfirmationService<JobPoster> {

    private EmailService emailService;


    @Autowired
    public JobPosterEmailConfirmationManager(EmailService emailService){
        this.emailService = emailService;
    }

    @Override
    public String sendConfirmationMail(User user) {
        String token = UUID.randomUUID().toString();
        
        emailService.sendMail(user.getEmail(), "EmailConfirmation", "Token : "+ token);
        return token;
    }


    @Override
    public boolean validateConfirmationToken(String token, JobPoster user) {
        return token.equals(user.getEmailConfirmation().getConfirmationToken());
    }
    
}
