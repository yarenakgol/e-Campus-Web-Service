package com.example.backend.service;

import com.example.backend.dto.FakulteCreateDTO;
import com.example.backend.dto.FakulteUpdateDTO;
import com.example.backend.dto.FakulteViewDTO;
import com.example.backend.exception.NotFoundException;
import com.example.backend.repository.FakulteRepository;
import com.example.backend.validator.model.Fakulte;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class FakulteServiceImpl implements FakulteService{
    private final FakulteRepository fakulteRepository;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public FakulteViewDTO getFakulteById(Long id) {
        final Fakulte fakulte = fakulteRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        return FakulteViewDTO.of(fakulte);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<FakulteViewDTO> getFakultes() {
        return fakulteRepository.findAll().stream().map(FakulteViewDTO::of).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public FakulteViewDTO createFakulte(FakulteCreateDTO fakulteCreateDTO) {
        final  Fakulte fakulte = fakulteRepository
                .save(new Fakulte(fakulteCreateDTO.getFakulteAd()));
        return null;
    }

    @Override
    @Transactional
    public FakulteViewDTO updateFakulte(Long id, FakulteUpdateDTO fakulteUpdateDTO) {
        final Fakulte fakulte = fakulteRepository.findById(id).orElseThrow(()->new NotFoundException("Not Found Exception"));
        fakulte.setFakulteAd(fakulteUpdateDTO.getFakulteAd());



        final Fakulte updateFakulte = fakulteRepository.save(fakulte);
        return FakulteViewDTO.of(updateFakulte);
    }

    @Override
    @Transactional
    public void deleteFakulte(Long id) {
        final  Fakulte fakulte= fakulteRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        fakulteRepository.deleteById(fakulte.getFakulteID());
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<FakulteViewDTO> slice(Pageable pageable) {
        return fakulteRepository.findAll(pageable).stream().map(FakulteViewDTO::of).collect(Collectors.toList());
    }
}
