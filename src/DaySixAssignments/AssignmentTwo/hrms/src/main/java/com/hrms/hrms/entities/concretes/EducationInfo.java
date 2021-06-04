package com.hrms.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "education_infos")
public class EducationInfo {
    
    @Id
    @GeneratedValue
    @Column(name = "education_info_id")
    private int educationInfoId;

    @Column(name = "name")
    private String name;

    @Column(name = "program")
    private String program;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "date_of_graduation")
    private LocalDate dateOfGraduation;

    @ManyToOne()
    private Resume resume;

}
