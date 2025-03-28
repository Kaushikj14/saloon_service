package com.example.Saloon.service.mapper;

import com.example.Saloon.service.modal.Saloon;
import com.example.Saloon.service.payload.dto.SaloonDTO;

public class SaloonMapper {

    public static SaloonDTO mapToDTO(Saloon saloon){
        SaloonDTO saloonDTO = new SaloonDTO();
        saloonDTO.setId(saloon.getId());
        saloonDTO.setName(saloon.getName());
        saloonDTO.setAddress(saloon.getAddress());
        saloonDTO.setCity(saloon.getCity());
        saloonDTO.setImages(saloon.getImages());

        return saloonDTO;
    }

}
