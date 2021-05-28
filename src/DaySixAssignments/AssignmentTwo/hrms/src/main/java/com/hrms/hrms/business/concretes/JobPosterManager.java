package com.hrms.hrms.business.concretes;

import java.util.List;

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
import com.hrms.hrms.entities.concretes.EmailConfirmation;
import com.hrms.hrms.entities.concretes.JobPoster;
import com.hrms.hrms.entities.concretes.UserConfirmation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class JobPosterManager implements JobPosterService {

    private JobPosterDao jobPosterDao;

    private Validator<BasicTuple<String, String>> emailValidator;

    private EmailConfirmationService<JobPoster> emailConfirmationService;

    @Autowired
    private JobPosterManager(JobPosterDao jobPosterDao,
            @Qualifier("domainEmailValidator") Validator<BasicTuple<String, String>> emailValidator,
            EmailConfirmationService<JobPoster> emailConfirmationService) {
        this.jobPosterDao = jobPosterDao;
        this.emailValidator = emailValidator;
        this.emailConfirmationService = emailConfirmationService;
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Result userConfirm(int confirmedUserId, int confirmerUserId) {
        // TODO Auto-generated method stub
        return null;
    }

}
