package com.hrms.hrms.entities.dataTransferObjects;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertCreateDto {
    
    private String jobDescription;

    private String city;

    private String wageRange;

    private int openPositionCount;

    private LocalDate lastApplicationDate;

    private int ownerId;

    private int jobPositionId;
}
