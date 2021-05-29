package com.hrms.hrms.dataAccess.abstracts;

import java.util.List;

import com.hrms.hrms.entities.concretes.JobAdvert;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobAdvertDao extends JpaRepository<JobAdvert,Integer>{
    
    List<JobAdvert> getByActiveState(boolean activeState);

    List<JobAdvert> getByActiveStateOrderByLastApplicationDate(boolean activeState);

    List<JobAdvert> getByOwner_Id(int ownerId);
}
