package com.example.backend.service;

import com.example.backend.dto.EnstituCreateDTO;
import com.example.backend.dto.EnstituUpdateDTO;
import com.example.backend.dto.EnstituViewDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EnstituService {
    EnstituViewDTO getEnstituById(Long id);
    List<EnstituViewDTO> getEnstitus();
    EnstituViewDTO createEnstitu(EnstituCreateDTO enstituCreateDTO);
    EnstituViewDTO updateEnstitu(Long id, EnstituUpdateDTO enstituUpdateDTO);
    void deleteEnstitu(Long id);
    List<EnstituViewDTO> slice(Pageable pageable);

}

