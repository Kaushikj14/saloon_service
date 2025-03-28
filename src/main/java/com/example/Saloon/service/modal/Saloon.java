package com.example.Saloon.service.modal;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data //(provides getter setter all ards contructer no args contructer to string)
public class Saloon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ElementCollection
    private List<String> images;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private Long ownerId;

    @Column(nullable = false)
    private  String phoneNumber;

    @Column(nullable = false)
    private LocalTime openTime;

    @Column(nullable = false)
    private LocalTime closingTime;








}
