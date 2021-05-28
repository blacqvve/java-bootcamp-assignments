package com.hrms.hrms.business.concretes;

import com.hrms.hrms.core.services.EmailService;

import org.springframework.stereotype.Component;

@Component
public class DefaultEmailManager implements EmailService {

    @Override
    public void sendMail(String to, String subject, String message) {
        System.out.println("Email Sent To " +to);
    }

}
