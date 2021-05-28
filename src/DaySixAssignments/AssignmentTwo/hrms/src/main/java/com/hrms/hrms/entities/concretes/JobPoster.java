package com.hrms.hrms.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_posters")
@PrimaryKeyJoinColumn(name="user_id")
public class JobPoster  extends User{
    
    @Column(name = "name")
    private String name;

    @Column(name = "website")
    private String website;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_confirmation_id")
    private UserConfirmation userConfirmation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email_confirmation_id")
    private EmailConfirmation emailConfirmation;

}
