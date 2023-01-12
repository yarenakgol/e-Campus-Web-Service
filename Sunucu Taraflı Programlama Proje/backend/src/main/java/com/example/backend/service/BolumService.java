package com.example.backend.service;

import com.example.backend.dto.BolumCreateDTO;
import com.example.backend.dto.BolumUpdateDTO;
import com.example.backend.dto.BolumViewDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BolumService {
    BolumViewDTO getBolumById(Long id);
    List<BolumViewDTO> getBolums();
    BolumViewDTO createBolum(BolumCreateDTO bolumCreateDTO);
    BolumViewDTO updateBolum(Long id, BolumUpdateDTO bolumUpdateDTO);
    void deleteBolum(Long id);
    List<BolumViewDTO> slice(Pageable pageable);

}

