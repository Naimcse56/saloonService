package com.naimcse56.saloonService.controller;

import com.naimcse56.saloonService.mapper.SaloonMapper;
import com.naimcse56.saloonService.model.Saloon;
import com.naimcse56.saloonService.payload.dto.SaloonDTO;
import com.naimcse56.saloonService.payload.dto.UserDTO;
import com.naimcse56.saloonService.service.SaloonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/saloons")
@RequiredArgsConstructor
public class SaloonController {
    private final SaloonService saloonService;

    @PostMapping
    public ResponseEntity<SaloonDTO> createSaloon(@RequestBody SaloonDTO saloonDTO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Saloon saloon = saloonService.createSaloon(saloonDTO, userDTO);
        SaloonDTO saloonDTO1 = SaloonMapper.mapToDTO(saloon);
        return ResponseEntity.ok(saloonDTO1);
    }

    @PatchMapping("{id}")
    public ResponseEntity<SaloonDTO> updateSaloon(@PathVariable("id") Long saloodId, @RequestBody SaloonDTO saloonDTO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Saloon saloon = saloonService.createSaloon(saloonDTO, userDTO);
        SaloonDTO saloonDTO1 = SaloonMapper.mapToDTO(saloon);
        return ResponseEntity.ok(saloonDTO1);
    }
}
