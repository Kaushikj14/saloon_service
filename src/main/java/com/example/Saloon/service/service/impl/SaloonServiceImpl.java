package com.example.Saloon.service.service.impl;

import com.example.Saloon.service.modal.Saloon;
import com.example.Saloon.service.payload.dto.SaloonDTO;
import com.example.Saloon.service.payload.dto.UserDTO;
import com.example.Saloon.service.repository.SaloonRepository;
import com.example.Saloon.service.service.SaloonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaloonServiceImpl implements SaloonService {


    private final SaloonRepository saloonRepository;

    @Override
    public Saloon createSaloon(SaloonDTO req, UserDTO user) {
        Saloon saloon = new Saloon();
        saloon.setName(req.getName());
        saloon.setAddress(req.getAddress());
        saloon.setEmail(req.getEmail());
        saloon.setCity(req.getCity());
        saloon.setImages(req.getImages());
        saloon.setClosingTime(req.getClosingTime());
        saloon.setOpenTime(req.getOpenTime());
        saloon.setOwnerId(req.getOwnerId());
        saloon.setPhoneNumber(req.getPhoneNumber());
        return saloonRepository.save(saloon);
    }

    @Override
    public Saloon updateSaloon(SaloonDTO saloon, UserDTO user, Long saloonId) throws Exception {
        Saloon existingSaloon = saloonRepository.findById(saloonId).orElse(null);

        if (existingSaloon!=null && saloon.getOwnerId().equals(user.getId())){
            existingSaloon.setName(saloon.getName());
            existingSaloon.setCity(saloon.getCity());
            existingSaloon.setOpenTime(saloon.getOpenTime());
            existingSaloon.setAddress(saloon.getAddress());
            existingSaloon.setPhoneNumber(saloon.getPhoneNumber());
            existingSaloon.setImages(saloon.getImages());
            existingSaloon.setClosingTime(saloon.getClosingTime());

//            saloonRepository.save(existingSaloon);
        }

        throw new Exception("Saloon not exists");
    }

    @Override
    public List<Saloon> getAllSaloons() {
        return saloonRepository.findAll();
    }

    @Override
    public Saloon getSaloonById(Long saloonId) throws Exception {
        Saloon saloon = saloonRepository.findById(saloonId).orElse(null);
        if (saloon!=null){
            return  saloon;
        }else{
            throw new Exception("Saloon does not exists");
        }
    }

    @Override
    public Saloon getSaloonByOwnerId(Long ownerId) {
        return saloonRepository.findByOwnerId(ownerId);
    }

    @Override
    public List<Saloon> getSaloonByCityName(String city) {
        return saloonRepository.searchSaloons(city);
    }
}
