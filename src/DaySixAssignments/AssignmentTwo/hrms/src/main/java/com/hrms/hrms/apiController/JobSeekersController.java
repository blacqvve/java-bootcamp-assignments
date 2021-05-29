package com.hrms.hrms.apiController;

import java.util.List;

import javax.validation.constraints.Email;

import com.hrms.hrms.business.abstracts.JobSeekerService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.entities.concretes.JobSeeker;
import com.hrms.hrms.entities.dataTransferObjects.JobSeekerConfirmationDto;
import com.hrms.hrms.entities.dataTransferObjects.JobSeekerRegisterDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobseekers/")
public class JobSeekersController {

    private JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekersController(JobSeekerService service) {
        this.jobSeekerService = service;
    }

    @GetMapping("getall")
    public DataResult<List<JobSeeker>> getAll() {
        return jobSeekerService.getAll();
    }

    @PostMapping("add")
    public Result add(@RequestBody JobSeekerRegisterDto dto) {

        if (!dto.getPassword().equals(dto.getPasswordRepeat())) {
            return new ErrorResult("Passwords doesn't match");
        }

        JobSeeker newJobSeeker = new JobSeeker();
        newJobSeeker.setEmail(dto.getEmail());
        newJobSeeker.setDateOfBirth(dto.getDateOfBirth());
        newJobSeeker.setName(dto.getName());
        newJobSeeker.setSurname(dto.getSurname());
        newJobSeeker.setPassword(dto.getPassword());
        newJobSeeker.setNationalIdentityNumber(dto.getNationalIdentityNumber());

        return jobSeekerService.add(newJobSeeker);
    }

    @PostMapping("confirmuser")
    public Result confirmUser(@RequestBody JobSeekerConfirmationDto dto){

        return jobSeekerService.confirmUser(dto.getToken(), dto.getId());
    }
}
