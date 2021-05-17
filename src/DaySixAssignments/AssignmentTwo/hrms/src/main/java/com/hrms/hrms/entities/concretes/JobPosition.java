package com.hrms.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="JobPositions")
public class JobPosition {
    
    @Id
    @GeneratedValue
    @Column(name="Id")
    private int id;


    @Column(name = "Name")
    private String name;

    @Column(name = "CreateDate")
    private LocalDateTime createDate;
}
