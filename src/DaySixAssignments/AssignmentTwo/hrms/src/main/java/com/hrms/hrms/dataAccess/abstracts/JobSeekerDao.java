package com.hrms.hrms.dataAccess.abstracts;

import com.hrms.hrms.entities.concretes.JobSeeker;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerDao extends JpaRepository<JobSeeker,Integer>{
    JobSeeker findByNationalIdentityNumberAndEmail(String nationalIdentityNumber,String email);
}
