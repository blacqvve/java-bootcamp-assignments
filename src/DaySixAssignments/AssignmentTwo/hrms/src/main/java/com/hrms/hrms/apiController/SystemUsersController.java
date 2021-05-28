package com.hrms.hrms.apiController;

import java.util.List;

import com.hrms.hrms.business.abstracts.SystemUserService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.SystemUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/systemUsers/")
public class SystemUsersController {

    private SystemUserService systemUserService;

    @Autowired
    public SystemUsersController(SystemUserService systemUserService) {
        this.systemUserService = systemUserService;
    }

    @GetMapping("getAll")
    public DataResult<List<SystemUser>> getAll() {
        return systemUserService.getAll();
    }

    @PostMapping("add")
    public Result add(@RequestBody SystemUser user) {
        return systemUserService.add(user);
    }

}
