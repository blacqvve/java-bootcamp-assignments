package com.hrms.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "confirmations")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Confirmation {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "confirmed")
    private Boolean confirmed;

    @Column(name = "confirmation_date")
    private LocalDate confirmationDate;
}
