package com.naimcse56.saloonService.mapper;

import com.naimcse56.saloonService.model.Saloon;
import com.naimcse56.saloonService.payload.dto.SaloonDTO;

public class SaloonMapper {

    public static SaloonDTO mapToDTO(Saloon saloon) {
        SaloonDTO saloonDTO = new SaloonDTO();
        saloonDTO.setName(saloon.getName());
        saloonDTO.setAddress(saloon.getAddress());
        saloonDTO.setCity(saloon.getCity());
        saloonDTO.setPhone(saloon.getPhone());
        saloonDTO.setEmail(saloon.getEmail());
        saloonDTO.setImages(saloon.getImages());
        saloonDTO.setOwnerId(saloon.getId());
        saloonDTO.setOpenTime(saloon.getOpenTime());
        saloonDTO.setCloseTime(saloon.getCloseTime());

        return saloonDTO;
    }
}
