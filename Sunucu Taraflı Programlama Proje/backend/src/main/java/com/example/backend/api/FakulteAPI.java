package com.example.backend.api;

import com.example.backend.dto.FakulteCreateDTO;
import com.example.backend.dto.FakulteUpdateDTO;
import com.example.backend.dto.FakulteViewDTO;
import com.example.backend.service.FakulteService;
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
public class FakulteAPI {
    private final FakulteService FakulteService;
    @GetMapping("v1/fakulte/{id}")
    public ResponseEntity<FakulteViewDTO> getFakulteById(@PathVariable("id") Long id){
        final FakulteViewDTO Fakulte = FakulteService.getFakulteById(id);
        return ResponseEntity.ok(Fakulte);
    }

    @GetMapping("v1/fakulte")
    public ResponseEntity<List<FakulteViewDTO>> getFakultes(){
        final List<FakulteViewDTO> Fakultes = FakulteService.getFakultes();
        return ResponseEntity.ok(Fakultes);
    }

    @PostMapping("v1/fakulte")
    public ResponseEntity<?> createFakulte(@Valid @RequestBody FakulteCreateDTO FakulteCreateDTO){
        FakulteService.createFakulte(FakulteCreateDTO);
        return ResponseEntity.ok(new GenericResponse("Fakulte "+FakulteCreateDTO.getFakulteAd()+" Created."));
    }

    @PutMapping("v1/fakulte/{id}")
    public ResponseEntity<FakulteViewDTO> updateFakulte(@Valid @PathVariable("id")Long id,
                                                          @RequestBody FakulteUpdateDTO FakulteUpdateDTO){
        final FakulteViewDTO Fakulte = FakulteService.updateFakulte(id, FakulteUpdateDTO);
        return ResponseEntity.ok(Fakulte);
    }
    @DeleteMapping("v1/fakulte/{id}")
    public ResponseEntity<?> deleteFakulte(@PathVariable("id") Long id){
        String message1 = FakulteService.getFakulteById(id).getFakulteAd();
        FakulteService.deleteFakulte(id);
        return ResponseEntity.ok(new GenericResponse(message1+"Deleted"));
    }

    @GetMapping("v1/fakulte/slice")
    public ResponseEntity<List<FakulteViewDTO>> slice(Pageable pageable){
        final List<FakulteViewDTO> Fakultes = FakulteService.slice(pageable);
        return ResponseEntity.ok(Fakultes);
    }

}
