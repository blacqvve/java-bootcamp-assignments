package com.hrms.hrms.business.abstracts;

import java.util.List;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.JobPoster;

public interface JobPosterService  {
    
    DataResult<List<JobPoster>> getAll();

    Result add(JobPoster jobPoster);

    Result emailConfirm(String token, int userId);

    Result userConfirm(int confirmedUserId, int confirmerUserId);
}
