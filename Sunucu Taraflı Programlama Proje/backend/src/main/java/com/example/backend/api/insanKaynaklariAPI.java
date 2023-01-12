package com.example.backend.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.dto.InsanKaynaklariCreateDTO;
import com.example.backend.dto.InsanKaynaklariUpdateDTO;
import com.example.backend.dto.InsanKaynaklariViewDTO;
import com.example.backend.service.InsanKaynaklariService;
import com.example.backend.shared.GenericResponse;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class insanKaynaklariAPI {

    private final InsanKaynaklariService InsanKaynaklariService;

    @GetMapping("v1/insanKaynaklari/{id}")
    public ResponseEntity<InsanKaynaklariViewDTO> getInsanKaynaklariById(@PathVariable("id") Long id) {
        final InsanKaynaklariViewDTO InsanKaynaklari = InsanKaynaklariService.getInsanKaynaklariById(id);
        return ResponseEntity.ok(InsanKaynaklari);
    }

    @GetMapping("v1/insanKaynaklari")
    public ResponseEntity<List<InsanKaynaklariViewDTO>> getInsanKaynaklaris() {
        final List<InsanKaynaklariViewDTO> InsanKaynaklaris = InsanKaynaklariService.getInsanKaynaklaris();
        return ResponseEntity.ok(InsanKaynaklaris);
    }

    @PostMapping("v1/insanKaynaklari")
    public ResponseEntity<?> createInsanKaynaklari(@Valid @RequestBody InsanKaynaklariCreateDTO InsanKaynaklariCreateDTO) {
        InsanKaynaklariService.createInsanKaynaklari(InsanKaynaklariCreateDTO);
        return ResponseEntity.ok(new GenericResponse("InsanKaynaklari kullanicisi "+InsanKaynaklariCreateDTO.getInsanKaynaklariAd()+InsanKaynaklariCreateDTO.getInsanKaynaklariSoyad()+" Created."));
    }

    @PutMapping("v1/insanKaynaklari/{id}")
    public ResponseEntity<InsanKaynaklariViewDTO> updateInsanKaynaklari(@Valid @PathVariable("id") Long id,
                                                  @RequestBody InsanKaynaklariUpdateDTO InsanKaynaklariUpdateDTO) {
        final InsanKaynaklariViewDTO InsanKaynaklari = InsanKaynaklariService.updateInsanKaynaklari(id, InsanKaynaklariUpdateDTO);
        return ResponseEntity.ok(InsanKaynaklari);
    }

    @DeleteMapping("v1/insanKaynaklari/{id}")
    public ResponseEntity<?> deleteInsanKaynaklari(@PathVariable("id") Long id) {
        String message1 = InsanKaynaklariService.getInsanKaynaklariById(id).getInsanKaynaklariAd();
        InsanKaynaklariService.deleteInsanKaynaklari(id);
        return ResponseEntity.ok(new GenericResponse(message1+" Deleted !"));
    }

    // More performance
    @GetMapping("v1/insanKaynaklari/slice")
    public ResponseEntity<List<InsanKaynaklariViewDTO>> slice(Pageable pageable) {
        final List<InsanKaynaklariViewDTO> InsanKaynaklaris = InsanKaynaklariService.slice(pageable);
        return ResponseEntity.ok(InsanKaynaklaris);
    }

}
