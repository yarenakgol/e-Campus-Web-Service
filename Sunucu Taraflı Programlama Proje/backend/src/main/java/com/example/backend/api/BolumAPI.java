package com.example.backend.api;

import com.example.backend.dto.BolumCreateDTO;
import com.example.backend.dto.BolumUpdateDTO;
import com.example.backend.dto.BolumViewDTO;
import com.example.backend.service.BolumService;
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
public class BolumAPI {
    private final BolumService BolumService;
    @GetMapping("v1/bolum/{id}")
    public ResponseEntity<BolumViewDTO> getBolumById(@PathVariable("id") Long id){
        final BolumViewDTO Bolum = BolumService.getBolumById(id);
        return ResponseEntity.ok(Bolum);
    }

    @GetMapping("v1/bolum")
    public ResponseEntity<List<BolumViewDTO>> getBolums(){
        final List<BolumViewDTO> Bolums = BolumService.getBolums();
        return ResponseEntity.ok(Bolums);
    }

    @PostMapping("v1/bolum")
    public ResponseEntity<?> createBolum(@Valid @RequestBody BolumCreateDTO BolumCreateDTO){
        BolumService.createBolum(BolumCreateDTO);
        return ResponseEntity.ok(new GenericResponse("Bolum "+BolumCreateDTO.getBolumAd()+" Created."));
    }

    @PutMapping("v1/bolum/{id}")
    public ResponseEntity<BolumViewDTO> updateBolum(@Valid @PathVariable("id")Long id,
                                                          @RequestBody BolumUpdateDTO BolumUpdateDTO){
        final BolumViewDTO Bolum = BolumService.updateBolum(id, BolumUpdateDTO);
        return ResponseEntity.ok(Bolum);
    }
    @DeleteMapping("v1/bolum/{id}")
    public ResponseEntity<?> deleteBolum(@PathVariable("id") Long id){
        String message1 = BolumService.getBolumById(id).getBolumAd();
        BolumService.deleteBolum(id);
        return ResponseEntity.ok(new GenericResponse(message1+"Deleted"));
    }

    @GetMapping("v1/bolum/slice")
    public ResponseEntity<List<BolumViewDTO>> slice(Pageable pageable){
        final List<BolumViewDTO> Bolums = BolumService.slice(pageable);
        return ResponseEntity.ok(Bolums);
    }

}
