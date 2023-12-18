package com.pablovass.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter
@Setter
@NoArgsConstructor

public class UserEntity {
    @Id
    @Column(nullable = false, length = 20)
    private String username;
    @Column(length = 50)
    private String password;
    @Column(length = 50)
    private String email;
    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean locked;
    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean disabled;
}/**
 username= admin
 disabled =0
 locked= o
 password= $2y$10$87QbadWVZxeevOdJjcVTgeV1i7SMwutdouIT1K4kyP9SbUd9GVAf6*/
//que seria admin123
//https://bcrypt.online/
/***
 username =customer
 disable=0
 locked=0
 pasword= customer132
 */
