package com.example.Saloon.service.payload.dto;

import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
public class UserDTO {

    private Long id;
    private String fullName;
    private String email;
}
