package com.hrms.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_adverts")
public class JobAdvert {
    
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="job_description")
    private String jobDescription;

    @Column(name="wage_range")
    private String wageRange;

    @Column(name="open_position_count")
    private int openPositionCount;

    @Column(name="last_application_date")
    private LocalDate lastApplicationDate;

    @Column(name="create_date")
    private LocalDate createDate;

    @Column(name="active_state")
    private boolean activeState;

    @Column(name="city_name")
    private String city;

    @ManyToOne
    private JobPoster owner;

    @ManyToOne
    private JobPosition jobPosition;


}
