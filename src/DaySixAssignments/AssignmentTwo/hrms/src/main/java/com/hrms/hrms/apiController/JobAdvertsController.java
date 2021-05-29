package com.hrms.hrms.apiController;

import java.util.List;

import com.hrms.hrms.business.abstracts.JobAdvertService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.JobAdvert;
import com.hrms.hrms.entities.concretes.JobPosition;
import com.hrms.hrms.entities.concretes.JobPoster;
import com.hrms.hrms.entities.dataTransferObjects.JobAdvertCreateDto;
import com.hrms.hrms.entities.dataTransferObjects.JobAdvertDisplayDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobAdverts/")
public class JobAdvertsController {
    
    private JobAdvertService jobAdvertService;

    @Autowired
    public JobAdvertsController(JobAdvertService jobAdvertService) {
        this.jobAdvertService = jobAdvertService;
    }


    @GetMapping("getAll")
    public DataResult<List<JobAdvertDisplayDto>> getAll(){
        return jobAdvertService.getAll();
    }
    
    @PostMapping("add")
    public Result add(@RequestBody JobAdvertCreateDto dto){
        JobAdvert newJob = new JobAdvert();

        newJob.setOwner(new JobPoster());
        newJob.getOwner().setId(dto.getOwnerId());

        newJob.setJobPosition(new JobPosition());
        newJob.getJobPosition().setId(dto.getJobPositionId());

        newJob.setJobDescription(dto.getJobDescription());
        newJob.setCity(dto.getCity());
        newJob.setOpenPositionCount(dto.getOpenPositionCount());
        newJob.setLastApplicationDate(dto.getLastApplicationDate());
        newJob.setWageRange(dto.getWageRange());


        return jobAdvertService.add(newJob);
    }
}
