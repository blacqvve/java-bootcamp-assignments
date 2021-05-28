package com.hrms.hrms.entities.concretes;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user_confirmations")
@PrimaryKeyJoinColumn(name = "user_confirmation_id")
public class UserConfirmation extends Confirmation{
    
    @OneToOne
    @JoinColumn(name = "validator_user_id")
    private SystemUser validatorUser;
}
