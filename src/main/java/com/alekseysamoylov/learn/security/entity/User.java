package com.alekseysamoylov.learn.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private String password;

    @Column
    private String name;

    @Transient
    private String rawPassword;

}
