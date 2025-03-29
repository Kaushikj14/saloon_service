package com.example.Saloon.service.payload.dto;

import lombok.Data;

import java.time.LocalTime;
import java.util.List;

//@Data
public class UserDTO {

    private Long id;
    private String fullName;
    private String email;

    public UserDTO() {

    }

    public UserDTO(Long id, String fullName, String email) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


