package com.example.backend.service;

import com.example.backend.dto.YoneticiCreateDTO;
import com.example.backend.dto.YoneticiUpdateDTO;
import com.example.backend.dto.YoneticiViewDTO;
import com.example.backend.exception.NotFoundException;
import com.example.backend.repository.YoneticiRepository;
import com.example.backend.validator.model.Yonetici;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class YoneticiServiceImpl implements YoneticiService{
    private final YoneticiRepository yoneticiRepository;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public YoneticiViewDTO getYoneticiById(Long id) {
        final Yonetici yonetici = yoneticiRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        return YoneticiViewDTO.of(yonetici);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<YoneticiViewDTO> getYoneticis() {
        return yoneticiRepository.findAll().stream().map(YoneticiViewDTO::of).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public YoneticiViewDTO createYonetici(YoneticiCreateDTO yoneticiCreateDTO) {
        final  Yonetici yonetici = yoneticiRepository
                .save(new Yonetici(yoneticiCreateDTO.getFakulteID(),yoneticiCreateDTO.getEnstituId(),yoneticiCreateDTO.getBolumID(),yoneticiCreateDTO.getPersonelID(),yoneticiCreateDTO.getYoneticiAd(),yoneticiCreateDTO.getYoneticiSoyad(),yoneticiCreateDTO.getYoneticiEmail(),yoneticiCreateDTO.getYoneticiTelNo(),yoneticiCreateDTO.getYoneticiGirisTarihi(),yoneticiCreateDTO.getYoneticiDogumGun(),yoneticiCreateDTO.getYoneticiKimlikNo()));
        return null;
    }

    @Override
    @Transactional
    public YoneticiViewDTO updateYonetici(Long id, YoneticiUpdateDTO yoneticiUpdateDTO) {
        final Yonetici yonetici = yoneticiRepository.findById(id).orElseThrow(()->new NotFoundException("Not Found Exception"));
        yonetici.setYoneticiAd(yoneticiUpdateDTO.getYoneticiAd());
        yonetici.setYoneticiSoyad(yoneticiUpdateDTO.getYoneticiSoyad());
        yonetici.setYoneticiEmail(yoneticiUpdateDTO.getYoneticiEmail());
        yonetici.setYoneticiTelNo(yoneticiUpdateDTO.getYoneticiTelNo());
        yonetici.setYoneticiGirisTarihi(yoneticiUpdateDTO.getYoneticiGirisTarihi());
        yonetici.setYoneticiDogumGun(yoneticiUpdateDTO.getYoneticiDogumGun());
        yonetici.setYoneticiKimlikNo(yoneticiUpdateDTO.getYoneticiKimlikNo());

        final Yonetici updateYonetici = yoneticiRepository.save(yonetici);
        return YoneticiViewDTO.of(updateYonetici);
    }

    @Override
    @Transactional
    public void deleteYonetici(Long id) {
        final  Yonetici yonetici= yoneticiRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        yoneticiRepository.deleteById(yonetici.getYoneticiID());
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<YoneticiViewDTO> slice(Pageable pageable) {
        return yoneticiRepository.findAll(pageable).stream().map(YoneticiViewDTO::of).collect(Collectors.toList());
    }
}
