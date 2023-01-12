package com.example.backend.service;

import com.example.backend.dto.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FakulteYonetimService {

    FakulteYonetimViewDTO getFakulteYonetimById(Long id);

    List<FakulteYonetimViewDTO> getFakulteYonetims();

    FakulteYonetimViewDTO createFakulteYonetim(FakulteYonetimCreateDTO fakulteYonetimCreateDTO);

    FakulteYonetimViewDTO updateFakulteYonetim(Long id, FakulteYonetimUpdateDTO fakulteYonetimUpdateDTO);

    void deleteFakulteYonetim(Long id);

    List<FakulteYonetimViewDTO> slice(Pageable pageable);

}