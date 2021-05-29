package com.hrms.hrms.business.concretes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.hrms.hrms.business.abstracts.JobAdvertService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.JobAdvertDao;
import com.hrms.hrms.dataAccess.abstracts.JobPositionDao;
import com.hrms.hrms.dataAccess.abstracts.JobPosterDao;
import com.hrms.hrms.entities.concretes.JobAdvert;
import com.hrms.hrms.entities.concretes.JobPosition;
import com.hrms.hrms.entities.concretes.JobPoster;
import com.hrms.hrms.entities.dataTransferObjects.JobAdvertDisplayDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobAdvertManager implements JobAdvertService {

    private JobAdvertDao jobAdvertDao;
    private JobPositionDao JobPositionDao;
    private JobPosterDao jobPosterDao;

    @Autowired
    public JobAdvertManager(JobAdvertDao jobAdvertDao, com.hrms.hrms.dataAccess.abstracts.JobPositionDao jobPositionDao,
            JobPosterDao jobPosterDao) {
        this.jobAdvertDao = jobAdvertDao;
        JobPositionDao = jobPositionDao;
        this.jobPosterDao = jobPosterDao;
    }

    @Override
    public DataResult<List<JobAdvertDisplayDto>> getAll() {
        List<JobAdvertDisplayDto> advertDisplayDtos = new ArrayList<JobAdvertDisplayDto>();

        List<JobAdvert> jobAdverts = jobAdvertDao.findAll();
        for(JobAdvert jobAdvert : jobAdverts){
            advertDisplayDtos.add(new JobAdvertDisplayDto(jobAdvert));
        }
        return new SuccessDataResult<List<JobAdvertDisplayDto>>(advertDisplayDtos);
    }

    @Override
    public Result add(JobAdvert jobAdvert) {

        Optional<JobPosition> jobPosition = JobPositionDao.findById(jobAdvert.getJobPosition().getId());

        Optional<JobPoster> owner = jobPosterDao.findById(jobAdvert.getOwner().getId());
        if (!jobPosition.isPresent())
            return new ErrorResult("Job position not found");

        if (!owner.isPresent())
            return new ErrorResult("Job poster not found");

        try {
            jobAdvert.setOwner(owner.get());
            jobAdvert.setJobPosition(jobPosition.get());

            jobAdvert.setActiveState(true);

            jobAdvert.setCreateDate(LocalDate.now());

            jobAdvertDao.save(jobAdvert);

            return new SuccessResult("Save succesful");
        } catch (Exception e) {
            return new ErrorResult(e.getMessage());
        }
    }

    @Override
    public Result changeActiveState(int advertId, boolean state) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DataResult<List<JobAdvertDisplayDto>> getByActiveState(boolean activeState) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DataResult<List<JobAdvertDisplayDto>> getByActiveStateOrderByLastApplicationDate(boolean activeState) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DataResult<List<JobAdvertDisplayDto>> getByOwner_Id(int ownerId) {
        // TODO Auto-generated method stub
        return null;
    }

}
