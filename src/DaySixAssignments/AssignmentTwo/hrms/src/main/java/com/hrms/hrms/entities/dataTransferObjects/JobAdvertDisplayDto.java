package com.hrms.hrms.entities.dataTransferObjects;

import java.time.LocalDate;

import com.hrms.hrms.entities.concretes.JobAdvert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertDisplayDto {
    
    private String companyName;

    private String jobPositionName;

    private int openPositionCount;

    private LocalDate createDate;

    private LocalDate lastApplicationDate;

    public JobAdvertDisplayDto(JobAdvert advert) {
        this.companyName = advert.getOwner().getName();
        this.jobPositionName = advert.getJobPosition().getName();
        this.openPositionCount = advert.getOpenPositionCount();
        this.createDate = advert.getCreateDate();
        this.lastApplicationDate = advert.getLastApplicationDate();
    }
    
}
