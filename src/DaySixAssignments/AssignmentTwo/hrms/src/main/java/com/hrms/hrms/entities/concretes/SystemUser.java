package com.hrms.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "system_user")
public class SystemUser extends User {
    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;
}
