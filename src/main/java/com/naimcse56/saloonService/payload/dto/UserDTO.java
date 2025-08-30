package com.naimcse56.saloonService.payload.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserDTO {
    private Long id;
    private String fullName;
    private String email;
}
