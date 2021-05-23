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
@Table(name="jobpositions")
public class JobPosition {
    
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;


    @Column(name = "name")
    private String name;

    @Column(name = "createDate")
    private LocalDateTime createDate;
}
