package com.example.Saloon.service.payload.dto;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalTime;
import java.util.List;

@Data
public class SaloonDTO {

    private Long id;
    private String name;
    private List<String> images;
    private String address;
    private String email;
    private String city;
    private Long ownerId;
//    private UserDTO owner;
    private  String phoneNumber;
    private LocalTime openTime;
    private LocalTime closingTime;

}
