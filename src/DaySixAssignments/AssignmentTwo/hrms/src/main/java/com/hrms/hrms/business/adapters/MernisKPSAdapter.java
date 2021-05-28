package com.hrms.hrms.business.adapters;

import com.hrms.hrms.entities.concretes.JobSeeker;

import org.springframework.stereotype.Component;

@Component
public class MernisKPSAdapter {
    
    public Boolean validatePerson(JobSeeker jobSeeker){
        return true;
    }
}
