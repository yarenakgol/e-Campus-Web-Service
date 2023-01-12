package com.example.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.backend.dto.InsanKaynaklariCreateDTO;
import com.example.backend.dto.InsanKaynaklariUpdateDTO;
import com.example.backend.dto.InsanKaynaklariViewDTO;
import com.example.backend.exception.NotFoundException;
import com.example.backend.validator.model.InsanKaynaklari;
import com.example.backend.repository.InsanKaynaklariRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class InsanKaynaklariServiceImpl implements InsanKaynaklariService {

    private final InsanKaynaklariRepository insanKaynaklariRepository;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public InsanKaynaklariViewDTO getInsanKaynaklariById(Long id) {
        final InsanKaynaklari insanKaynaklari = insanKaynaklariRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        return InsanKaynaklariViewDTO.of(insanKaynaklari);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<InsanKaynaklariViewDTO> getInsanKaynaklaris() {
        return insanKaynaklariRepository.findAll().stream().map(InsanKaynaklariViewDTO::of).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public InsanKaynaklariViewDTO createInsanKaynaklari(InsanKaynaklariCreateDTO insanKaynaklariCreateDTO) {
        final InsanKaynaklari insanKaynaklari = insanKaynaklariRepository
                .save(new InsanKaynaklari(insanKaynaklariCreateDTO.getInsanKaynaklariAd(),insanKaynaklariCreateDTO.getInsanKaynaklariSoyad(), insanKaynaklariCreateDTO.getInsanKaynaklariEmail(),insanKaynaklariCreateDTO.getInsanKaynaklariTelNo(),insanKaynaklariCreateDTO.getInsanKaynaklariGirisTarihi(),insanKaynaklariCreateDTO.getInsanKaynaklariDogumGun(),insanKaynaklariCreateDTO.getInsanKaynaklariKimlikNo()));
        return InsanKaynaklariViewDTO.of(insanKaynaklari);
    }

    @Override
    @Transactional
    public InsanKaynaklariViewDTO updateInsanKaynaklari(Long id, InsanKaynaklariUpdateDTO insanKaynaklariUpdateDTO) {
        final InsanKaynaklari insanKaynaklari = insanKaynaklariRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        insanKaynaklari.setInsanKaynaklariAd(insanKaynaklariUpdateDTO.getInsanKaynaklariAd());
        insanKaynaklari.setInsanKaynaklariSoyad(insanKaynaklariUpdateDTO.getInsanKaynaklariSoyad());
        insanKaynaklari.setInsanKaynaklariEmail(insanKaynaklariUpdateDTO.getInsanKaynaklariEmail());
        insanKaynaklari.setInsanKaynaklariTelNo(insanKaynaklariUpdateDTO.getInsanKaynaklariTelNo());
        insanKaynaklari.setInsanKaynaklariGirisTarihi(insanKaynaklariUpdateDTO.getInsanKaynaklariGirisTarihi());
        insanKaynaklari.setInsanKaynaklariDogumGun(insanKaynaklariUpdateDTO.getInsanKaynaklariDogumGun());
        insanKaynaklari.setInsanKaynaklariKimlikNo(insanKaynaklariUpdateDTO.getInsanKaynaklariKimlikNo());

        final InsanKaynaklari updatedInsanKaynaklari = insanKaynaklariRepository.save(insanKaynaklari);
        return InsanKaynaklariViewDTO.of(updatedInsanKaynaklari);
    }

    @Override
    @Transactional
    public void deleteInsanKaynaklari(Long id) {
        final InsanKaynaklari insanKaynaklari = insanKaynaklariRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        insanKaynaklariRepository.deleteById(insanKaynaklari.getInsanKaynaklariID());
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<InsanKaynaklariViewDTO> slice(Pageable pageable) {
        return insanKaynaklariRepository.findAll(pageable).stream().map(InsanKaynaklariViewDTO::of).collect(Collectors.toList());
    }

}
