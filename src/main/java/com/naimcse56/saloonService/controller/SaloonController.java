package com.naimcse56.saloonService.controller;

import com.naimcse56.saloonService.mapper.SaloonMapper;
import com.naimcse56.saloonService.model.Saloon;
import com.naimcse56.saloonService.payload.dto.SaloonDTO;
import com.naimcse56.saloonService.payload.dto.UserDTO;
import com.naimcse56.saloonService.service.SaloonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PatchMapping("/{id}")
    public ResponseEntity<SaloonDTO> updateSaloon(@PathVariable("id") Long saloonId, @RequestBody SaloonDTO saloonDTO) throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Saloon saloon = saloonService.updateSaloon(saloonDTO, userDTO, saloonId);
        SaloonDTO saloonDTO1 = SaloonMapper.mapToDTO(saloon);
        return ResponseEntity.ok(saloonDTO1);
    }

    @GetMapping
    public ResponseEntity<List<SaloonDTO>> getSaloons(){

        List<Saloon> saloons = saloonService.getAllSaloon();
        List<SaloonDTO> saloonDTOS = saloons.stream().map((saloon) ->
                {
                    SaloonDTO saloonDTO = SaloonMapper.mapToDTO(saloon);
                    return saloonDTO;
                }
                ).toList();
        return ResponseEntity.ok(saloonDTOS);
    }

    @GetMapping("/{saloonId}")
    public ResponseEntity<SaloonDTO> getSaloonById(@PathVariable("saloonId") Long saloonId) throws Exception {

        Saloon saloon = saloonService.getSaloonById(saloonId);

        SaloonDTO saloonDTO = SaloonMapper.mapToDTO(saloon);

        return ResponseEntity.ok(saloonDTO);
    }

    //    http://localhost:8091/api/saloons/search?city=dhaka
    @GetMapping("/search")
    public ResponseEntity<List<SaloonDTO>> searchSaloons(@RequestParam("city") String city){

        List<Saloon> saloons = saloonService.searchSaloonByCityName(city);

        List<SaloonDTO> saloonDTOS = saloons.stream().map((saloon) ->
                {
                    SaloonDTO saloonDTO = SaloonMapper.mapToDTO(saloon);
                    return saloonDTO;
                }
        ).toList();
        return ResponseEntity.ok(saloonDTOS);
    }

    @GetMapping("/owner")
    public ResponseEntity<SaloonDTO> getSaloonByOwnerId(@PathVariable("ownerId") Long ownerId) throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Saloon saloon = saloonService.getSaloonByOwnerId(userDTO.getId());

        SaloonDTO saloonDTO = SaloonMapper.mapToDTO(saloon);

        return ResponseEntity.ok(saloonDTO);
    }
}
