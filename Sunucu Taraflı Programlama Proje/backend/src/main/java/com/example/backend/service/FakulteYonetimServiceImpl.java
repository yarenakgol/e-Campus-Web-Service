package com.example.backend.service;

import com.example.backend.dto.FakulteYonetimCreateDTO;
import com.example.backend.dto.FakulteYonetimUpdateDTO;
import com.example.backend.dto.FakulteYonetimViewDTO;
import com.example.backend.exception.NotFoundException;
import com.example.backend.repository.FakulteYonetimRepository;
import com.example.backend.validator.model.FakulteYonetim;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FakulteYonetimServiceImpl implements FakulteYonetimService {

    private final FakulteYonetimRepository fakulteYonetimRepository;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public FakulteYonetimViewDTO getFakulteYonetimById(Long id) {
        final FakulteYonetim fakulteYonetim = fakulteYonetimRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        return FakulteYonetimViewDTO.of(fakulteYonetim);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<FakulteYonetimViewDTO> getFakulteYonetims() {
        return fakulteYonetimRepository.findAll().stream().map(FakulteYonetimViewDTO::of).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public FakulteYonetimViewDTO createFakulteYonetim(FakulteYonetimCreateDTO fakulteYonetimCreateDTO) {
        final FakulteYonetim fakulteYonetim = fakulteYonetimRepository
                .save(new FakulteYonetim(fakulteYonetimCreateDTO.getBolumFakYonId(),fakulteYonetimCreateDTO.getPersonelFakYonId(),fakulteYonetimCreateDTO.getFakulteYonetimAd(),fakulteYonetimCreateDTO.getFakulteYonetimSoyad(), fakulteYonetimCreateDTO.getFakulteYonetimEmail(),fakulteYonetimCreateDTO.getFakulteYonetimTelNo(),fakulteYonetimCreateDTO.getFakulteYonetimGirisTarihi(),fakulteYonetimCreateDTO.getFakulteYonetimDogumGun(),fakulteYonetimCreateDTO.getFakulteYonetimKimlikNo()));
        return FakulteYonetimViewDTO.of(fakulteYonetim);
    }

    @Override
    @Transactional
    public FakulteYonetimViewDTO updateFakulteYonetim(Long id, FakulteYonetimUpdateDTO fakulteYonetimUpdateDTO) {
        final FakulteYonetim fakulteYonetim = fakulteYonetimRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        fakulteYonetim.setFakulteYonetimAd(fakulteYonetimUpdateDTO.getFakulteYonetimAd());
        fakulteYonetim.setFakulteYonetimSoyad(fakulteYonetimUpdateDTO.getFakulteYonetimSoyad());
        fakulteYonetim.setFakulteYonetimEmail(fakulteYonetimUpdateDTO.getFakulteYonetimEmail());
        fakulteYonetim.setFakulteYonetimTelNo(fakulteYonetimUpdateDTO.getFakulteYonetimTelNo());
        fakulteYonetim.setFakulteYonetimGirisTarihi(fakulteYonetimUpdateDTO.getFakulteYonetimGirisTarihi());
        fakulteYonetim.setFakulteYonetimDogumGun(fakulteYonetimUpdateDTO.getFakulteYonetimDogumGun());
        fakulteYonetim.setFakulteYonetimKimlikNo(fakulteYonetimUpdateDTO.getFakulteYonetimKimlikNo());

        final FakulteYonetim updatedFakulteYonetim = fakulteYonetimRepository.save(fakulteYonetim);
        return FakulteYonetimViewDTO.of(updatedFakulteYonetim);
    }

    @Override
    @Transactional
    public void deleteFakulteYonetim(Long id) {
        final FakulteYonetim fakulteYonetim = fakulteYonetimRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        fakulteYonetimRepository.deleteById(fakulteYonetim.getID());
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<FakulteYonetimViewDTO> slice(Pageable pageable) {
        return fakulteYonetimRepository.findAll(pageable).stream().map(FakulteYonetimViewDTO::of).collect(Collectors.toList());
    }

}
