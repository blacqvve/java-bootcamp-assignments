package com.hrms.hrms.core.services;

public interface EmailService {
    
    public void sendMail(String to, String subject, String message);
}
