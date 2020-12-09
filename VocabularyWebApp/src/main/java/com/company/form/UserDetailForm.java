package com.company.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDetailForm {

    private Integer id;

    private String name;
    private String surname;
    private String email;
    private Integer score;
    private String password;

    public UserDetailForm() {
    }

    public UserDetailForm(Integer id , String name, String surname, String email, Integer score, String password) {
        this.id=id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.score = score;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }
}
