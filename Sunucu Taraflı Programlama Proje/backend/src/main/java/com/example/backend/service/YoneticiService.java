package com.example.backend.service;
import com.example.backend.dto.*;
import com.example.backend.dto.YoneticiCreateDTO;
import com.example.backend.dto.YoneticiUpdateDTO;
import com.example.backend.dto.YoneticiViewDTO;
import com.example.backend.validator.model.Yonetici;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface YoneticiService {
    YoneticiViewDTO getYoneticiById(Long id);
    List<YoneticiViewDTO> getYoneticis();
    YoneticiViewDTO createYonetici(YoneticiCreateDTO yoneticiCreateDTO);
    YoneticiViewDTO updateYonetici(Long id, YoneticiUpdateDTO yoneticiUpdateDTO);
    void deleteYonetici(Long id);
    List<YoneticiViewDTO> slice(Pageable pageable);

}

