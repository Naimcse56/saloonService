package com.naimcse56.saloonService.service.implementation;

import com.naimcse56.saloonService.model.Saloon;
import com.naimcse56.saloonService.payload.dto.SaloonDTO;
import com.naimcse56.saloonService.payload.dto.UserDTO;
import com.naimcse56.saloonService.repository.SaloonRepository;
import com.naimcse56.saloonService.service.SaloonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaloonServiceImplementation implements SaloonService {

    private final SaloonRepository saloonRepository;

    @Override
    public Saloon createSaloon(SaloonDTO request, UserDTO user) {
        Saloon saloon = new Saloon();
        saloon.setName(request.getName());
        saloon.setAddress(request.getAddress());
        saloon.setCity(request.getCity());
        saloon.setPhone(request.getPhone());
        saloon.setEmail(request.getEmail());
        saloon.setImages(request.getImages());
        saloon.setOwnerId(user.getId());
        saloon.setOpenTime(request.getOpenTime());
        saloon.setCloseTime(request.getCloseTime());
        return saloonRepository.save(saloon);
    }

    @Override
    public Saloon updateSaloon(SaloonDTO saloon, UserDTO user, Long saloonId) throws Exception {
        Saloon existingSaloon = saloonRepository.findById(saloonId).orElse(null);
        if (existingSaloon != null && saloon.getOwnerId().equals(user.getId())) {
            existingSaloon.setName(saloon.getName());
            existingSaloon.setAddress(saloon.getAddress());
            existingSaloon.setCity(saloon.getCity());
            existingSaloon.setPhone(saloon.getPhone());
            existingSaloon.setEmail(saloon.getEmail());
            existingSaloon.setImages(saloon.getImages());
            existingSaloon.setOwnerId(user.getId());
            existingSaloon.setOpenTime(saloon.getOpenTime());
            existingSaloon.setCloseTime(saloon.getCloseTime());
            return saloonRepository.save(existingSaloon);
        }
        throw new Exception("Saloon not Added");
    }

    @Override
    public List<Saloon> getAllSaloon() {
        return saloonRepository.findAll();
    }

    @Override
    public Saloon getSaloonById(Long id) throws Exception {
        Saloon saloon = saloonRepository.findById(id).orElse(null);
        if (saloon == null) {
            throw new Exception("Saloon not Exists!");
        }
        return saloon;
    }

    @Override
    public Saloon getSaloonByOwnerId(Long ownerId) {
        return saloonRepository.findByOwnerId(ownerId);
    }

    @Override
    public List<Saloon> searchSaloonByCityName(String city) {
        return saloonRepository.searchSaloons(city);
    }
}
