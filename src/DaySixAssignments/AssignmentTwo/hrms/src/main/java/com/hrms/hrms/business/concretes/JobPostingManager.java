package com.hrms.hrms.business.concretes;

import java.util.List;

import com.hrms.hrms.business.abstracts.JobPostingService;
import com.hrms.hrms.dataAccess.abstracts.JobPositionDao;
import com.hrms.hrms.entities.concretes.JobPosition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobPostingManager implements JobPostingService {

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPostingManager(JobPositionDao jobPositionDao){
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public List<JobPosition> getAll() {
        return jobPositionDao.findAll();
    }
    
}
