package com.example.backend.service;

import com.example.backend.dto.DonemCreateDTO;
import com.example.backend.dto.DonemUpdateDTO;
import com.example.backend.dto.DonemViewDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DonemService {
    DonemViewDTO getDonemById(Long id);
    List<DonemViewDTO> getDonems();
    DonemViewDTO createDonem(DonemCreateDTO donemCreateDTO);
    DonemViewDTO updateDonem(Long id, DonemUpdateDTO donemUpdateDTO);
    void deleteDonem(Long id);
    List<DonemViewDTO> slice(Pageable pageable);

}

