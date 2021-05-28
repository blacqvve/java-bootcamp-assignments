package com.hrms.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.hrms.hrms.business.abstracts.EmailConfirmationService;
import com.hrms.hrms.business.abstracts.JobSeekerService;
import com.hrms.hrms.business.adapters.MernisKPSAdapter;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.core.utilities.validators.abstracts.Validator;
import com.hrms.hrms.dataAccess.abstracts.JobSeekerDao;
import com.hrms.hrms.entities.concretes.EmailConfirmation;
import com.hrms.hrms.entities.concretes.JobSeeker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;

    private MernisKPSAdapter mernisAdapter;

    private Validator<String> emailValidator;

    private EmailConfirmationService emailConfirmationService;

    @Autowired
    private JobSeekerManager(JobSeekerDao jobSeekerDao, MernisKPSAdapter mernisAdapter,
            @Qualifier("emailValidator") Validator<String> emailValidator,EmailConfirmationService emailConfirmationService) {
        this.jobSeekerDao = jobSeekerDao;
        this.mernisAdapter = mernisAdapter;
        this.emailValidator = emailValidator;
        this.emailConfirmationService = emailConfirmationService;
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll());
    }

    @Override
    public Result add(JobSeeker jobSeeker) {

        if (!emailValidator.validate(jobSeeker.getEmail())) {
            return new ErrorResult("Email is not valid");
        }
        if (!mernisAdapter.validatePerson(jobSeeker))
            return new ErrorResult("Person is not valid");

        try {
            jobSeeker.setEmailConfirmation(new EmailConfirmation());
            jobSeeker.getEmailConfirmation().setConfirmed(false);
            jobSeeker.getEmailConfirmation().setConfirmationToken(emailConfirmationService.sendConfirmationMail(jobSeeker));
            jobSeekerDao.save(jobSeeker);
            return new SuccessResult("Register sucessfull");
        } catch (Exception e) {
            return new ErrorResult(e.getMessage());
        }
    }

    @Override
    public Result update(JobSeeker jobSeeker) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Result confirmUser(String token, int userId) {
        Optional<JobSeeker> optionalUser = jobSeekerDao.findById(userId);
        if(optionalUser.isPresent()){
            JobSeeker user = optionalUser.get();

            if (emailConfirmationService.validateConfirmationToken(token, user)){

                user.getEmailConfirmation().setConfirmationDate(LocalDate.now());

                user.getEmailConfirmation().setConfirmed(true);

                jobSeekerDao.save(user);

                return new SuccessResult("Email confirmed");
            }
            else{
                return new ErrorResult("Token mismatch");
            }
        }
        return new ErrorResult("User not found");
    }

}
