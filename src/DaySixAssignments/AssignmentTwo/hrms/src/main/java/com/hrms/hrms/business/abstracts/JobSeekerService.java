package com.hrms.hrms.business.abstracts;

import java.util.List;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
    
    DataResult<List<JobSeeker>> getAll();

    Result add(JobSeeker jobSeeker);

    Result update(JobSeeker jobSeeker);

    Result confirmUser(String token, int userId);
}
