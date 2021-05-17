package com.hrms.hrms.business.abstracts;

import java.util.List;

import com.hrms.hrms.entities.concretes.JobPosition;

public interface JobPostingService {
    List<JobPosition> getAll();
}
