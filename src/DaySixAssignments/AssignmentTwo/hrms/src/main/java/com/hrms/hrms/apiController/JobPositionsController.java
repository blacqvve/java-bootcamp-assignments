package com.hrms.hrms.apiController;

import java.util.List;

import com.hrms.hrms.business.abstracts.JobPositionService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.JobPosition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobpositions/")
public class JobPositionsController {
    
    private JobPositionService jobPostingService;

    @Autowired
    public JobPositionsController(JobPositionService jobPostingService){
        this.jobPostingService = jobPostingService;
    }

    @GetMapping("getAll")
    public DataResult<List<JobPosition>> getAll(){
        return jobPostingService.getAll();
    }

    @PostMapping("add")
    public Result add(@RequestBody JobPosition newPosition){
        return jobPostingService.add(newPosition);
    }


}
