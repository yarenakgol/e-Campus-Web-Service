package com.example.backend.api;

import com.example.backend.dto.OgrenciIsleriCreateDTO;
import com.example.backend.dto.OgrenciIsleriUpdateDTO;
import com.example.backend.dto.OgrenciIsleriViewDTO;
import com.example.backend.service.OgrenciIsleriService;
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
public class OgrenciIsleriAPI {

    private final OgrenciIsleriService OgrenciIsleriService;

    @GetMapping("v1/ogrenciIsleri/{id}")
    public ResponseEntity<OgrenciIsleriViewDTO> getOgrenciIsleriById(@PathVariable("id") Long id) {
        final OgrenciIsleriViewDTO OgrenciIsleri = OgrenciIsleriService.getOgrenciIsleriById(id);
        return ResponseEntity.ok(OgrenciIsleri);
    }

    @GetMapping("v1/ogrenciIsleri")
    public ResponseEntity<List<OgrenciIsleriViewDTO>> getOgrenciIsleris() {
        final List<OgrenciIsleriViewDTO> OgrenciIsleris = OgrenciIsleriService.getOgrenciIsleris();
        return ResponseEntity.ok(OgrenciIsleris);
    }

    @PostMapping("v1/ogrenciIsleri")
    public ResponseEntity<?> createOgrenciIsleri(@Valid @RequestBody OgrenciIsleriCreateDTO OgrenciIsleriCreateDTO) {
        OgrenciIsleriService.createOgrenciIsleri(OgrenciIsleriCreateDTO);
        return ResponseEntity.ok(new GenericResponse("OgrenciIsleri kullanicisi "+OgrenciIsleriCreateDTO.getOgrenciIsleriAd()+OgrenciIsleriCreateDTO.getOgrenciIsleriSoyad()+" Created."));
    }

    @PutMapping("v1/ogrenciIsleri/{id}")
    public ResponseEntity<OgrenciIsleriViewDTO> updateOgrenciIsleri(@Valid @PathVariable("id") Long id,
                                                  @RequestBody OgrenciIsleriUpdateDTO OgrenciIsleriUpdateDTO) {
        final OgrenciIsleriViewDTO OgrenciIsleri = OgrenciIsleriService.updateOgrenciIsleri(id, OgrenciIsleriUpdateDTO);
        return ResponseEntity.ok(OgrenciIsleri);
    }

    @DeleteMapping("v1/ogrenciIsleri/{id}")
    public ResponseEntity<?> deleteOgrenciIsleri(@PathVariable("id") Long id) {
        String message1 = OgrenciIsleriService.getOgrenciIsleriById(id).getOgrenciIsleriAd();
        OgrenciIsleriService.deleteOgrenciIsleri(id);
        return ResponseEntity.ok(new GenericResponse(message1+" Deleted !"));
    }

    // More performance
    @GetMapping("v1/ogrenciIsleri/slice")
    public ResponseEntity<List<OgrenciIsleriViewDTO>> slice(Pageable pageable) {
        final List<OgrenciIsleriViewDTO> OgrenciIsleris = OgrenciIsleriService.slice(pageable);
        return ResponseEntity.ok(OgrenciIsleris);
    }

}
