package com.alekseysamoylov.learn.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString(exclude = "password")
@Accessors(chain = true)
@Entity
@Table(name = "learn_user")
public class User {

    @Id
    private Long id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String name;
}
