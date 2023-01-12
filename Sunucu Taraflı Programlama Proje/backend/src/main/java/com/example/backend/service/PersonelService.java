package com.example.backend.service;
import com.example.backend.dto.*;
import com.example.backend.dto.PersonelCreateDTO;
import com.example.backend.dto.PersonelUpdateDTO;
import com.example.backend.dto.PersonelViewDTO;
import com.example.backend.validator.model.Personel;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface PersonelService {
    PersonelViewDTO getPersonelById(Long id);
    List<PersonelViewDTO> getPersonels();
    PersonelViewDTO createPersonel(PersonelCreateDTO personelCreateDTO);
    PersonelViewDTO updatePersonel(Long id, PersonelUpdateDTO personelUpdateDTO);
    void deletePersonel(Long id);
    List<PersonelViewDTO> slice(Pageable pageable);

}

