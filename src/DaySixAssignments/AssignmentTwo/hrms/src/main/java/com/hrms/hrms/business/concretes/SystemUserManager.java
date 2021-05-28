package com.hrms.hrms.business.concretes;

import java.util.List;

import com.hrms.hrms.business.abstracts.SystemUserService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.dataAccess.abstracts.SystemUserDao;
import com.hrms.hrms.entities.concretes.SystemUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemUserManager implements SystemUserService {

    private SystemUserDao systemUserDao;
    
    @Autowired
    public SystemUserManager(SystemUserDao systemUserDao) {
        this.systemUserDao = systemUserDao;
    }

    @Override
    public DataResult<List<SystemUser>> getAll() {
        return new SuccessDataResult<List<SystemUser>>(systemUserDao.findAll());
    }

    @Override
    public Result add() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
