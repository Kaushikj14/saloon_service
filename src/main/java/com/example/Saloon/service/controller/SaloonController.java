package com.example.Saloon.service.controller;


import com.example.Saloon.service.mapper.SaloonMapper;
import com.example.Saloon.service.modal.Saloon;
import com.example.Saloon.service.payload.dto.SaloonDTO;
import com.example.Saloon.service.payload.dto.UserDTO;
import com.example.Saloon.service.repository.SaloonRepository;
import com.example.Saloon.service.service.SaloonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/saloons")
//@RequiredArgsConstructor
public class SaloonController {

//    @Autowired
    private final SaloonService saloonService;

    @Autowired  // ✅ Spring will inject the dependency
    public SaloonController(SaloonService saloonService) {
        this.saloonService = saloonService;
    }

    @PostMapping
    public ResponseEntity<SaloonDTO> createSaloon(@RequestBody SaloonDTO saloonDTO){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Saloon saloon = saloonService.createSaloon(saloonDTO,userDTO);
        SaloonDTO saloonDTO1 = SaloonMapper.mapToDTO(saloon);

        return ResponseEntity.ok(saloonDTO1);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SaloonDTO> updateSaloon(@PathVariable("id") Long saloonId,@RequestBody SaloonDTO saloonDTO) throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Saloon saloon = saloonService.updateSaloon(saloonDTO,userDTO,saloonId);
        SaloonDTO saloonDTO1 = SaloonMapper.mapToDTO(saloon);
        return ResponseEntity.ok(saloonDTO1);
    }

    @GetMapping()
    public ResponseEntity<List<SaloonDTO>> getSaloons() throws Exception {

        List<Saloon> saloons = saloonService.getAllSaloons();

        List<SaloonDTO> saloonDTOS = saloons.stream().map((saloon)->{
           SaloonDTO saloonDTO = SaloonMapper.mapToDTO(saloon);
           return saloonDTO;
        }).toList();

        return ResponseEntity.ok(saloonDTOS);
    }

    @GetMapping("{saloonId}")
    public ResponseEntity<SaloonDTO> getSaloonById(@PathVariable Long saloonId) throws Exception {

        Saloon saloon = saloonService.getSaloonById(saloonId);
        SaloonDTO saloonDTO = SaloonMapper.mapToDTO(saloon);

        return ResponseEntity.ok(saloonDTO);
    }

    @GetMapping("/search")
    public ResponseEntity<List<SaloonDTO>> searchSaloons(@RequestParam("city") String city) throws Exception {

        List<Saloon> saloons = saloonService.getSaloonByCityName(city);

        List<SaloonDTO> saloonDTOS = saloons.stream().map((saloon)->{
            SaloonDTO saloonDTO = SaloonMapper.mapToDTO(saloon);
            return saloonDTO;
        }).toList();

        return ResponseEntity.ok(saloonDTOS);
    }

    @GetMapping("/owner")
    public ResponseEntity<SaloonDTO> getSaloonByOwnerId(@PathVariable Long saloonId) throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);

        Saloon saloon = saloonService.getSaloonById(userDTO.getId());
        SaloonDTO saloonDTO = SaloonMapper.mapToDTO(saloon);

        return ResponseEntity.ok(saloonDTO);
    }





}
