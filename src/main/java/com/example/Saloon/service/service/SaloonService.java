package com.example.Saloon.service.service;

import com.example.Saloon.service.modal.Saloon;
import com.example.Saloon.service.payload.dto.SaloonDTO;
import com.example.Saloon.service.payload.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SaloonService {

    Saloon createSaloon(SaloonDTO saloon, UserDTO user);

    Saloon updateSaloon(SaloonDTO saloon, UserDTO user,Long saloonId) throws Exception;

    List<Saloon> getAllSaloons();

    Saloon getSaloonById(Long saloonId) throws Exception;

    Saloon getSaloonByOwnerId(Long ownerId);

    List<Saloon> getSaloonByCityName(String city);

}
