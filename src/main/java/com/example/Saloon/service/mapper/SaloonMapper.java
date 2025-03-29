package com.example.Saloon.service.mapper;

import com.example.Saloon.service.modal.Saloon;
import com.example.Saloon.service.payload.dto.SaloonDTO;

public class SaloonMapper {

    public static SaloonDTO mapToDTO(Saloon saloon){
        SaloonDTO saloonDTO = new SaloonDTO();
//        saloonDTO.setId(saloon.getId());
//        saloonDTO.setName(saloon.getName());
//        saloonDTO.setAddress(saloon.getAddress());
//        saloonDTO.setCity(saloon.getCity());
//        saloonDTO.setImages(saloon.getImages());

        saloonDTO.setId(saloon.getId());
        saloonDTO.setName(saloon.getName());
        saloonDTO.setAddress(saloon.getAddress());
        saloonDTO.setCity(saloon.getCity());
        saloonDTO.setEmail(saloon.getEmail());
        saloonDTO.setImages(saloon.getImages());
        saloonDTO.setOwnerId(saloon.getOwnerId()); // ✅ Ensure ownerId is mapped
        saloonDTO.setPhoneNumber(saloon.getPhoneNumber()); // ✅ Ensure phoneNumber is mapped
        saloonDTO.setOpenTime(saloon.getOpenTime()); // ✅ Ensure openTime is mapped
        saloonDTO.setClosingTime(saloon.getClosingTime()); // ✅ En

        return saloonDTO;
    }

}
