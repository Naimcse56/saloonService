package com.naimcse56.saloonService.service;

import com.naimcse56.saloonService.model.Saloon;
import com.naimcse56.saloonService.payload.dto.SaloonDTO;
import com.naimcse56.saloonService.payload.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SaloonService {
    Saloon createSaloon(SaloonDTO saloon, UserDTO user);

    Saloon updateSaloon(SaloonDTO saloon, UserDTO user, Long saloonId) throws Exception;

    List<Saloon> getAllSaloon();

    Saloon getSaloonById(Long id) throws Exception;

    Saloon getSaloonByOwnerId(Long ownerId);

    List<Saloon> searchSaloonByCityName(String city);
}
