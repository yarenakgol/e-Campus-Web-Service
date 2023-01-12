package com.example.backend.service;

import com.example.backend.dto.FakulteCreateDTO;
import com.example.backend.dto.FakulteUpdateDTO;
import com.example.backend.dto.FakulteViewDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FakulteService {
    FakulteViewDTO getFakulteById(Long id);
    List<FakulteViewDTO> getFakultes();
    FakulteViewDTO createFakulte(FakulteCreateDTO fakulteCreateDTO);
    FakulteViewDTO updateFakulte(Long id, FakulteUpdateDTO fakulteUpdateDTO);
    void deleteFakulte(Long id);
    List<FakulteViewDTO> slice(Pageable pageable);

}

