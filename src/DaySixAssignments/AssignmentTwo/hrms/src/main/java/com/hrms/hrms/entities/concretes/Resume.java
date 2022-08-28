package com.hrms.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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

    @Column(name = "description")
    private String description;

    @Column(name = "picture_url")
    private String pictureUrl;

    @Column(name="github_url")
    private String githubURL;

    @Column(name ="linkedin_url")
    private String linkedInURL;

    @Column(name = "create_date")
    private LocalDate createDate;

    @OneToMany(mappedBy = "resume",cascade = CascadeType.ALL)
    private List<LanguageInfo> languageInfos;

    @OneToMany(mappedBy = "resume",cascade = CascadeType.ALL)
    private List<EducationInfo> educationInfo;

    @OneToMany(mappedBy = "resume",cascade = CascadeType.ALL)
    private List<WorkInfo> workInfos;

    @OneToMany(mappedBy = "resume",cascade = CascadeType.ALL)
    private List<ProgrammingLanguage> programmingLanguages;

    @ManyToOne
    private JobSeeker owner;
}
