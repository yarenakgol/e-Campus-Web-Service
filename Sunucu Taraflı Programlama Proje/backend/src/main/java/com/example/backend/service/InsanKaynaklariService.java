package com.example.backend.service;

import com.example.backend.dto.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InsanKaynaklariService {

    InsanKaynaklariViewDTO getInsanKaynaklariById(Long id);

    List<InsanKaynaklariViewDTO> getInsanKaynaklaris();

    InsanKaynaklariViewDTO createInsanKaynaklari(InsanKaynaklariCreateDTO insanKaynaklariCreateDTO);

    InsanKaynaklariViewDTO updateInsanKaynaklari(Long id, InsanKaynaklariUpdateDTO insanKaynaklariUpdateDTO);

    void deleteInsanKaynaklari(Long id);

    List<InsanKaynaklariViewDTO> slice(Pageable pageable);

}
