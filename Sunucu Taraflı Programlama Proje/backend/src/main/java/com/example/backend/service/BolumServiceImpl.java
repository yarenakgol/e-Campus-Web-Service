package com.example.backend.service;

import com.example.backend.dto.BolumCreateDTO;
import com.example.backend.dto.BolumUpdateDTO;
import com.example.backend.dto.BolumViewDTO;
import com.example.backend.exception.NotFoundException;
import com.example.backend.repository.BolumRepository;
import com.example.backend.validator.model.Bolum;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class BolumServiceImpl implements BolumService{
    private final BolumRepository bolumRepository;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public BolumViewDTO getBolumById(Long id) {
        final Bolum bolum = bolumRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        return BolumViewDTO.of(bolum);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<BolumViewDTO> getBolums() {
        return bolumRepository.findAll().stream().map(BolumViewDTO::of).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public BolumViewDTO createBolum(BolumCreateDTO bolumCreateDTO) {
        final  Bolum bolum = bolumRepository
                .save(new Bolum(bolumCreateDTO.getBolumAd()));
        return null;
    }

    @Override
    @Transactional
    public BolumViewDTO updateBolum(Long id, BolumUpdateDTO bolumUpdateDTO) {
        final Bolum bolum = bolumRepository.findById(id).orElseThrow(()->new NotFoundException("Not Found Exception"));
        bolum.setBolumAd(bolumUpdateDTO.getBolumAd());




        final Bolum updateBolum = bolumRepository.save(bolum);
        return BolumViewDTO.of(updateBolum);
    }

    @Override
    @Transactional
    public void deleteBolum(Long id) {
        final  Bolum bolum= bolumRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        bolumRepository.deleteById(bolum.getId());
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<BolumViewDTO> slice(Pageable pageable) {
        return bolumRepository.findAll(pageable).stream().map(BolumViewDTO::of).collect(Collectors.toList());
    }
}
