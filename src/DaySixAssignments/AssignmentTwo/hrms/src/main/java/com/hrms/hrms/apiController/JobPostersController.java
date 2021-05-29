package com.hrms.hrms.apiController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.hrms.hrms.business.abstracts.JobPosterService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.JobPoster;
import com.hrms.hrms.entities.dataTransferObjects.JobPosterRegisterDto;

@RestController
@RequestMapping("/api/jobPosters/")
public class JobPostersController {

    private JobPosterService jobPosterService;

    @Autowired
    public JobPostersController(JobPosterService jobPosterService) {
        this.jobPosterService = jobPosterService;
    }

    @GetMapping("getAll")
    public DataResult<List<JobPoster>> getAll() {
        return jobPosterService.getAll();
    }

    @PostMapping("add")
    public Result add(@RequestBody JobPosterRegisterDto dto) {

        if(!dto.getPassword().equals(dto.getPasswordRepeat())){
            return new ErrorResult("Passwords does not match");
        }
        
        JobPoster jPoster = new JobPoster();

        jPoster.setEmail(dto.getEmail());
        
        jPoster.setPassword(dto.getPassword());

        jPoster.setName(dto.getName());

        jPoster.setPhone(dto.getPhone());

        jPoster.setWebsite(dto.getWebsite());

    
        
        return jobPosterService.add(jPoster);
    }

    @PostMapping("confirmEmail")
    public Result confirmEmail(@RequestParam("token") String token,@RequestParam("userId") int userId){
        return jobPosterService.emailConfirm(token, userId);
    }

    @PostMapping("userValidation")
    public Result userValidation(@RequestParam("confirmedUserId") int confirmedUserId,@RequestParam("confirmerUserId") int confirmerUserId){
        return jobPosterService.userConfirm(confirmedUserId, confirmerUserId);
    }
}
