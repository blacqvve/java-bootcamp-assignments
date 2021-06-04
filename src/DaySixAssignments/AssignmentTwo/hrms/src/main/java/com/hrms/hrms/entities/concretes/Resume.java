package com.hrms.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resumes")
public class Resume {
    
    @Id
    @GeneratedValue
    @Column(name = "resume_id")
    private int resumeId;

    @Column(name="github_url")
    private String githubURL;

    @Column(name ="linkedin_url")
    private String linkedInURL;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "resume")
    private List<LanguageInfo> languageInfos;

    @OneToMany(mappedBy = "resume")
    private List<EducationInfo> educationInfo;

    @OneToMany(mappedBy = "resume")
    private List<WorkInfo> workInfos;
}
