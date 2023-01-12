package com.example.backend.service;

import com.example.backend.dto.DonemCreateDTO;
import com.example.backend.dto.DonemUpdateDTO;
import com.example.backend.dto.DonemViewDTO;
import com.example.backend.exception.NotFoundException;
import com.example.backend.repository.DonemRepository;
import com.example.backend.validator.model.Donem;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class DonemServiceImpl implements DonemService{
    private final DonemRepository donemRepository;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public DonemViewDTO getDonemById(Long id) {
        final Donem donem = donemRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        return DonemViewDTO.of(donem);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<DonemViewDTO> getDonems() {
        return donemRepository.findAll().stream().map(DonemViewDTO::of).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public DonemViewDTO createDonem(DonemCreateDTO donemCreateDTO) {
        final  Donem donem = donemRepository
                .save(new Donem(donemCreateDTO.getName(),donemCreateDTO.getKrediToplam()));
        return null;
    }

    @Override
    @Transactional
    public DonemViewDTO updateDonem(Long id, DonemUpdateDTO donemUpdateDTO) {
        final Donem donem = donemRepository.findById(id).orElseThrow(()->new NotFoundException("Not Found Exception"));
        donem.setName(donemUpdateDTO.getName());
        donem.setKrediToplam(donemUpdateDTO.getKrediToplam());




        final Donem updateDonem = donemRepository.save(donem);
        return DonemViewDTO.of(updateDonem);
    }

    @Override
    @Transactional
    public void deleteDonem(Long id) {
        final  Donem donem= donemRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        donemRepository.deleteById(donem.getId());
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<DonemViewDTO> slice(Pageable pageable) {
        return donemRepository.findAll(pageable).stream().map(DonemViewDTO::of).collect(Collectors.toList());
    }
}
