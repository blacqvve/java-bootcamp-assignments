package com.hrms.hrms.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import com.hrms.hrms.business.abstracts.JobPositionService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.JobPositionDao;
import com.hrms.hrms.entities.concretes.JobPosition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new DataResult<List<JobPosition>>(jobPositionDao.findAll(), true);
    }

    @Override
    public Result add(JobPosition jobPosition) {

        JobPosition possibleDuplicate = jobPositionDao.findByNameIs(jobPosition.getName());
        if (possibleDuplicate == null) {
            jobPosition.setCreateDate(LocalDateTime.now());
            jobPositionDao.saveAndFlush(jobPosition);
            return new SuccessResult("Job position added succesfully");
        }
        return new ErrorResult("Job position already exist");
    }

}
