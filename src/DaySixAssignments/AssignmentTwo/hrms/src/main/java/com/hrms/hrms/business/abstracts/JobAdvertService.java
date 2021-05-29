package com.hrms.hrms.business.abstracts;

import java.util.List;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.JobAdvert;
import com.hrms.hrms.entities.dataTransferObjects.JobAdvertDisplayDto;

public interface JobAdvertService {

    DataResult<List<JobAdvertDisplayDto>> getAll();

    Result add(JobAdvert jobAdvert);

    Result changeActiveState(int advertId, boolean state);


    DataResult<List<JobAdvertDisplayDto>> getByActiveState(boolean activeState);

    DataResult<List<JobAdvertDisplayDto>> getByActiveStateOrderByLastApplicationDate(boolean activeState);

    DataResult<List<JobAdvertDisplayDto>> getByOwner_Id(int ownerId);




}
