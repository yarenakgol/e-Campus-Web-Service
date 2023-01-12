package com.example.backend.service;

import com.example.backend.dto.EnstituCreateDTO;
import com.example.backend.dto.EnstituUpdateDTO;
import com.example.backend.dto.EnstituViewDTO;
import com.example.backend.exception.NotFoundException;
import com.example.backend.repository.EnstituRepository;
import com.example.backend.validator.model.Enstitu;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class EnstituServiceImpl implements EnstituService{
    private final EnstituRepository enstituRepository;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public EnstituViewDTO getEnstituById(Long id) {
        final Enstitu enstitu = enstituRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        return EnstituViewDTO.of(enstitu);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<EnstituViewDTO> getEnstitus() {
        return enstituRepository.findAll().stream().map(EnstituViewDTO::of).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public EnstituViewDTO createEnstitu(EnstituCreateDTO enstituCreateDTO) {
        final  Enstitu enstitu = enstituRepository
                .save(new Enstitu(enstituCreateDTO.getBolumEnstituId(), enstituCreateDTO.getLisansEnstituId(), enstituCreateDTO.getPersonelEnstituId()));
        return null;
    }

    @Override
    @Transactional
    public EnstituViewDTO updateEnstitu(Long id, EnstituUpdateDTO enstituUpdateDTO) {
        final Enstitu enstitu = enstituRepository.findById(id).orElseThrow(()->new NotFoundException("Not Found Exception"));
        enstitu.setBolumEnstituId(enstituUpdateDTO.getBolumEnstituId());
        enstitu.setLisansEnstituId(enstituUpdateDTO.getLisansEnstituId());
        enstitu.setPersonelEnstituId(enstituUpdateDTO.getPersonelEnstituId());




        final Enstitu updateEnstitu = enstituRepository.save(enstitu);
        return EnstituViewDTO.of(updateEnstitu);
    }

    @Override
    @Transactional
    public void deleteEnstitu(Long id) {
        final  Enstitu enstitu= enstituRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        enstituRepository.deleteById(enstitu.getId());
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<EnstituViewDTO> slice(Pageable pageable) {
        return enstituRepository.findAll(pageable).stream().map(EnstituViewDTO::of).collect(Collectors.toList());
    }
}
