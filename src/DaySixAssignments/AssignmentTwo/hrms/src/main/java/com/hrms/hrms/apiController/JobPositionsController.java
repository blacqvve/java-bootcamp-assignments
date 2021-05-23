package com.hrms.hrms.apiController;

import java.util.List;

import com.hrms.hrms.business.abstracts.JobPostingService;
import com.hrms.hrms.entities.concretes.JobPosition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobpositions/")
public class JobPositionsController {
    
    private JobPostingService jobPostingService;

    @Autowired
    public JobPositionsController(JobPostingService jobPostingService)
    {
        this.jobPostingService = jobPostingService;
    }

    @GetMapping("getAll")
    public List<JobPosition> getAll(){
        return jobPostingService.getAll();
    }
}
