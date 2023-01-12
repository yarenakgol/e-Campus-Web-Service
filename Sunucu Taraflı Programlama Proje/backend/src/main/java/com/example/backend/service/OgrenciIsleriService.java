package com.example.backend.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.backend.dto.OgrenciIsleriCreateDTO;
import com.example.backend.dto.OgrenciIsleriUpdateDTO;
import com.example.backend.dto.OgrenciIsleriViewDTO;

/**
 *
 * @author KadirRA
 * @since 1.0
 */
public interface OgrenciIsleriService {

    OgrenciIsleriViewDTO getOgrenciIsleriById(Long id);

    List<OgrenciIsleriViewDTO> getOgrenciIsleris();

    OgrenciIsleriViewDTO createOgrenciIsleri(OgrenciIsleriCreateDTO ogrenciIsleriCreateDTO);

    OgrenciIsleriViewDTO updateOgrenciIsleri(Long id, OgrenciIsleriUpdateDTO OgrenciIsleriUpdateDTO);

    void deleteOgrenciIsleri(Long id);

    List<OgrenciIsleriViewDTO> slice(Pageable pageable);

}
