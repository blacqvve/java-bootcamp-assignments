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
@Table(name="work_infos")
public class WorkInfo {
    
    @Id
    @GeneratedValue
    @Column(name = "work_info_id")
    private int workInfoId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "position")
    private String position;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "employement_end_date")
    private LocalDate employementEndDate;

    @ManyToOne()
    private Resume resume;
}
