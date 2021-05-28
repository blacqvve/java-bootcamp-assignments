package com.hrms.hrms.dataAccess.abstracts;

import com.hrms.hrms.entities.concretes.JobPoster;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPosterDao extends JpaRepository<JobPoster,Integer> {
    
}
