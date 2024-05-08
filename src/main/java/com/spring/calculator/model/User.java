package com.spring.calculator.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String password;
    @Transient
    private String cnfPassword;

    private String role;

    public User(){}

    public User(String email, String password, String cnfPassword) {
        this.email = email;
        this.password = password;
        this.cnfPassword = cnfPassword;
    }

    public User(int id, String email, String password, String cnfPassword) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.cnfPassword = cnfPassword;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCnfPassword() {
        return cnfPassword;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCnfPassword(String cnfPassword) {
        this.cnfPassword = cnfPassword;
    }

    public String getAuthority() {
        return role;
    }

    public void setAuthority(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", cnfPassword='" + cnfPassword + '\'' +
                '}';
    }
}
