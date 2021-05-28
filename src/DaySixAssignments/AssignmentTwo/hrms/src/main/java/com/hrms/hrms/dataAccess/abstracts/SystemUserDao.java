package com.hrms.hrms.dataAccess.abstracts;

import com.hrms.hrms.entities.concretes.SystemUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemUserDao extends JpaRepository<SystemUser,Integer>{
    
}
