package com.example.backend.service;

import com.example.backend.dto.PersonelCreateDTO;
import com.example.backend.dto.PersonelUpdateDTO;
import com.example.backend.dto.PersonelViewDTO;
import com.example.backend.exception.NotFoundException;
import com.example.backend.repository.PersonelRepository;
import com.example.backend.validator.model.Personel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PersonelServiceImpl implements PersonelService{
    private final PersonelRepository personelRepository;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public PersonelViewDTO getPersonelById(Long id) {
        final Personel personel = personelRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        return PersonelViewDTO.of(personel);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<PersonelViewDTO> getPersonels() {
        return personelRepository.findAll().stream().map(PersonelViewDTO::of).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public PersonelViewDTO createPersonel(PersonelCreateDTO personelCreateDTO) {
        final  Personel personel = personelRepository
                .save(new Personel(personelCreateDTO.getPersonel_Name(),personelCreateDTO.getPersonel_LastName(),personelCreateDTO.getPersonel_Gorev()));
        return null;
    }

    @Override
    @Transactional
    public PersonelViewDTO updatePersonel(Long id, PersonelUpdateDTO personelUpdateDTO) {
        final Personel personel = personelRepository.findById(id).orElseThrow(()->new NotFoundException("Not Found Exception"));
        personel.setPersonel_Name(personelUpdateDTO.getPersonel_Name());
        personel.setPersonel_LastName(personelUpdateDTO.getPersonel_LastName());
        personel.setPersonel_Gorev(personelUpdateDTO.getPersonel_Gorev());


        final Personel updatePersonel = personelRepository.save(personel);
        return PersonelViewDTO.of(updatePersonel);
    }

    @Override
    @Transactional
    public void deletePersonel(Long id) {
        final  Personel personel= personelRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        personelRepository.deleteById(personel.getPersonelID());
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<PersonelViewDTO> slice(Pageable pageable) {
        return personelRepository.findAll(pageable).stream().map(PersonelViewDTO::of).collect(Collectors.toList());
    }
}
