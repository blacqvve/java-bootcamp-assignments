package com.hrms.hrms.dataAccess.abstracts;

import com.hrms.hrms.entities.concretes.Resume;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeDao extends JpaRepository<Resume,Integer> {
    
}
