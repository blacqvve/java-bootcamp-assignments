package com.hrms.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user_confirmations")
public class UserConfirmation extends Confirmation{
    
    @Column(name = "validator_user")
    @OneToOne
    private SystemUser validatorUser;
}
