package com.example.backend.api;

import com.example.backend.dto.PersonelCreateDTO;
import com.example.backend.dto.PersonelUpdateDTO;
import com.example.backend.dto.PersonelViewDTO;
import com.example.backend.service.PersonelService;
import com.example.backend.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PersonelAPI {
    private final PersonelService PersonelService;
    @GetMapping("v1/personel/{id}")
    public ResponseEntity<PersonelViewDTO> getPersonelById(@PathVariable("id") Long id){
        final PersonelViewDTO Personel = PersonelService.getPersonelById(id);
        return ResponseEntity.ok(Personel);
    }

    @GetMapping("v1/personel")
    public ResponseEntity<List<PersonelViewDTO>> getPersonels(){
        final List<PersonelViewDTO> Personels = PersonelService.getPersonels();
        return ResponseEntity.ok(Personels);
    }

    @PostMapping("v1/personel")
    public ResponseEntity<?> createPersonel(@Valid @RequestBody PersonelCreateDTO PersonelCreateDTO){
        PersonelService.createPersonel(PersonelCreateDTO);
        return ResponseEntity.ok(new GenericResponse("Personel "+PersonelCreateDTO.getPersonel_Name()+PersonelCreateDTO.getPersonel_LastName()+"Created."));
    }

    @PutMapping("v1/personel/{id}")
    public ResponseEntity<PersonelViewDTO> updatePersonel(@Valid @PathVariable("id")Long id,
                                                          @RequestBody PersonelUpdateDTO PersonelUpdateDTO){
        final PersonelViewDTO Personel = PersonelService.updatePersonel(id, PersonelUpdateDTO);
        return ResponseEntity.ok(Personel);
    }
    @DeleteMapping("v1/personel/{id}")
    public ResponseEntity<?> deletePersonel(@PathVariable("id") Long id){
        String message1 = PersonelService.getPersonelById(id).getPersonel_Name();
        PersonelService.deletePersonel(id);
        return ResponseEntity.ok(new GenericResponse(message1+"Deleted"));
    }

    @GetMapping("v1/personel/slice")
    public ResponseEntity<List<PersonelViewDTO>> slice(Pageable pageable){
        final List<PersonelViewDTO> Personels = PersonelService.slice(pageable);
        return ResponseEntity.ok(Personels);
    }

}
