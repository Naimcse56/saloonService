package com.naimcse56.saloonService.payload.dto;

import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
public class SaloonDTO {
    private Long id;
    private String name;
    private List<String> images;
    private String address;
    private String phone;
    private String email;
    private String city;
    private Long ownerId;
    private LocalTime openTime;
    private LocalTime closeTime;
}
