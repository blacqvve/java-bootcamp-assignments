package com.hrms.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "email_confirmations")
public class EmailConfirmation extends Confirmation {
    
    @Column(name = "confirmationToken")
    private String confirmationToken;
}
