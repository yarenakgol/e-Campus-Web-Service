package com.example.backend.api;

import com.example.backend.dto.FakulteYonetimCreateDTO;
import com.example.backend.dto.FakulteYonetimUpdateDTO;
import com.example.backend.dto.FakulteYonetimViewDTO;
import com.example.backend.service.FakulteYonetimService;
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
public class FakulteYonetimAPI {

    private final FakulteYonetimService FakulteYonetimService;

    @GetMapping("v1/fakulteYonetim/{id}")
    public ResponseEntity<FakulteYonetimViewDTO> getFakulteYonetimById(@PathVariable("id") Long id) {
        final FakulteYonetimViewDTO FakulteYonetim = FakulteYonetimService.getFakulteYonetimById(id);
        return ResponseEntity.ok(FakulteYonetim);
    }

    @GetMapping("v1/fakulteYonetim")
    public ResponseEntity<List<FakulteYonetimViewDTO>> getFakulteYonetims() {
        final List<FakulteYonetimViewDTO> FakulteYonetims = FakulteYonetimService.getFakulteYonetims();
        return ResponseEntity.ok(FakulteYonetims);
    }

    @PostMapping("v1/fakulteYonetim")
    public ResponseEntity<?> createFakulteYonetim(@Valid @RequestBody FakulteYonetimCreateDTO FakulteYonetimCreateDTO) {
        FakulteYonetimService.createFakulteYonetim(FakulteYonetimCreateDTO);
        return ResponseEntity.ok(new GenericResponse("FakulteYonetim kullanicisi "+FakulteYonetimCreateDTO.getFakulteYonetimAd()+FakulteYonetimCreateDTO.getFakulteYonetimSoyad()+" Created."));
    }

    @PutMapping("v1/fakulteYonetim/{id}")
    public ResponseEntity<FakulteYonetimViewDTO> updateFakulteYonetim(@Valid @PathVariable("id") Long id,
                                                  @RequestBody FakulteYonetimUpdateDTO FakulteYonetimUpdateDTO) {
        final FakulteYonetimViewDTO FakulteYonetim = FakulteYonetimService.updateFakulteYonetim(id, FakulteYonetimUpdateDTO);
        return ResponseEntity.ok(FakulteYonetim);
    }

    @DeleteMapping("v1/fakulteYonetim/{id}")
    public ResponseEntity<?> deleteFakulteYonetim(@PathVariable("id") Long id) {
        String message1 = FakulteYonetimService.getFakulteYonetimById(id).getFakulteYonetimAd();
        FakulteYonetimService.deleteFakulteYonetim(id);
        return ResponseEntity.ok(new GenericResponse(message1+" Deleted !"));
    }

    // More performance
    @GetMapping("v1/fakulteYonetim/slice")
    public ResponseEntity<List<FakulteYonetimViewDTO>> slice(Pageable pageable) {
        final List<FakulteYonetimViewDTO> FakulteYonetims = FakulteYonetimService.slice(pageable);
        return ResponseEntity.ok(FakulteYonetims);
    }

}
