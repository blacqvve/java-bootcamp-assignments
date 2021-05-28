package com.hrms.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.hrms.hrms.business.abstracts.EmailConfirmationService;
import com.hrms.hrms.business.abstracts.JobPosterService;
import com.hrms.hrms.core.utilities.BasicTuple;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.core.utilities.validators.abstracts.Validator;
import com.hrms.hrms.dataAccess.abstracts.JobPosterDao;
import com.hrms.hrms.dataAccess.abstracts.SystemUserDao;
import com.hrms.hrms.entities.concretes.EmailConfirmation;
import com.hrms.hrms.entities.concretes.JobPoster;
import com.hrms.hrms.entities.concretes.SystemUser;
import com.hrms.hrms.entities.concretes.UserConfirmation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class JobPosterManager implements JobPosterService {

    private JobPosterDao jobPosterDao;

    private SystemUserDao systemUserDao;

    private Validator<BasicTuple<String, String>> emailValidator;

    private EmailConfirmationService<JobPoster> emailConfirmationService;

    @Autowired
    private JobPosterManager(JobPosterDao jobPosterDao,SystemUserDao systemUserDao,
            @Qualifier("domainEmailValidator") Validator<BasicTuple<String, String>> emailValidator,
            EmailConfirmationService<JobPoster> emailConfirmationService) {
        this.jobPosterDao = jobPosterDao;
        this.emailValidator = emailValidator;
        this.emailConfirmationService = emailConfirmationService;
        this.systemUserDao = systemUserDao;
    }

    @Override
    public DataResult<List<JobPoster>> getAll() {
        return new SuccessDataResult<List<JobPoster>>(jobPosterDao.findAll());
    }

    @Override
    public Result add(JobPoster jobPoster) {

        if (!emailValidator.validate(new BasicTuple<String, String>(jobPoster.getEmail(), jobPoster.getWebsite()))) {
            return new ErrorResult("Email is not valid for this company");
        }

        try {

            jobPoster.setEmailConfirmation(new EmailConfirmation());
            jobPoster.getEmailConfirmation().setConfirmed(false);
            jobPoster.getEmailConfirmation()
                    .setConfirmationToken(emailConfirmationService.sendConfirmationMail(jobPoster));
            jobPoster.setUserConfirmation(new UserConfirmation());
            jobPoster.getUserConfirmation().setConfirmed(false);
            jobPosterDao.save(jobPoster);

            return new SuccessResult("User added successfuly");
        } catch (Exception e) {
            return new ErrorResult(e.getMessage());
        }
    }

    @Override
    public Result emailConfirm(String token, int userId) {
        Optional<JobPoster> jobPoster = jobPosterDao.findById(userId);

        if(!jobPoster.isPresent()){
            return new ErrorResult("User not found");
        }
        boolean confirmation = emailConfirmationService.validateConfirmationToken(token, jobPoster.get());

        if(confirmation){
            jobPoster.get().getEmailConfirmation().setConfirmed(confirmation);
            jobPoster.get().getEmailConfirmation().setConfirmationDate(LocalDate.now());
            try {
                jobPosterDao.save(jobPoster.get());
                return new Result(confirmation,"email confirmed");
            } catch (Exception e) {
                return new ErrorResult(e.getMessage());
            }
        }
        else{
            return new ErrorResult("user email not confirmed");
        }
        
    }

    @Override
    public Result userConfirm(int confirmedUserId, int confirmerUserId) {
        Optional<JobPoster> confirmedUser = jobPosterDao.findById(confirmedUserId);
        Optional<SystemUser> confirmerUser = systemUserDao.findById(confirmerUserId);

        if(!confirmedUser.isPresent() || !confirmerUser.isPresent()){
            return new ErrorResult("Confirmed or confirmer user not found");
        }

        try {
            confirmedUser.get().getUserConfirmation().setValidatorUser(confirmerUser.get());
            confirmedUser.get().getUserConfirmation().setConfirmed(true);
            confirmedUser.get().getUserConfirmation().setConfirmationDate(LocalDate.now());

            jobPosterDao.save(confirmedUser.get());
            return new SuccessResult("User confirmed");
        } catch (Exception e) {
            return new ErrorResult(e.getMessage());
        }
    }

}
