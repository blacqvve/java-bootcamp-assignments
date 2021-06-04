package com.hrms.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "language_infos")
public class LanguageInfo {
    
    @Id
    @GeneratedValue
    @Column(name = "language_info_id")
    private int languageInfoId;

    @Column(name = "name")
    private String languageName;

    @Column(name = "grade")
    private int grade;

    @ManyToOne
    private Resume resume;
}
