package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.entities.concretes.User;

public interface EmailConfirmationService<T extends User> {
    
    public String sendConfirmationMail(User user);

    public boolean validateConfirmationToken(String token, T user);
}
