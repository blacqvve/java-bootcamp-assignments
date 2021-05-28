package com.hrms.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "email_confirmations")
@PrimaryKeyJoinColumn(name = "email_confirmation_id")
public class EmailConfirmation extends Confirmation {
    
    @Column(name = "confirmationToken")
    private String confirmationToken;
}
