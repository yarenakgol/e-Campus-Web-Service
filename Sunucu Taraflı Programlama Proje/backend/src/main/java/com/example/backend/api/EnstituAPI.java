package com.example.backend.api;

import com.example.backend.dto.EnstituCreateDTO;
import com.example.backend.dto.EnstituUpdateDTO;
import com.example.backend.dto.EnstituViewDTO;
import com.example.backend.service.EnstituService;
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
public class EnstituAPI {
    private final EnstituService EnstituService;
    @GetMapping("v1/enstitu/{id}")
    public ResponseEntity<EnstituViewDTO> getEnstituById(@PathVariable("id") Long id){
        final EnstituViewDTO Enstitu = EnstituService.getEnstituById(id);
        return ResponseEntity.ok(Enstitu);
    }

    @GetMapping("v1/enstitu")
    public ResponseEntity<List<EnstituViewDTO>> getEnstitus(){
        final List<EnstituViewDTO> Enstitus = EnstituService.getEnstitus();
        return ResponseEntity.ok(Enstitus);
    }

    @PostMapping("v1/enstitu")
    public ResponseEntity<?> createEnstitu(@Valid @RequestBody EnstituCreateDTO EnstituCreateDTO){
        EnstituService.createEnstitu(EnstituCreateDTO);
        return ResponseEntity.ok(new GenericResponse("Enstitu "+EnstituCreateDTO.getBolumEnstituId()+" Created."));
    }

    @PutMapping("v1/enstitu/{id}")
    public ResponseEntity<EnstituViewDTO> updateEnstitu(@Valid @PathVariable("id")Long id,
                                                          @RequestBody EnstituUpdateDTO EnstituUpdateDTO){
        final EnstituViewDTO Enstitu = EnstituService.updateEnstitu(id, EnstituUpdateDTO);
        return ResponseEntity.ok(Enstitu);
    }
    @DeleteMapping("v1/enstitu/{id}")
    public ResponseEntity<?> deleteEnstitu(@PathVariable("id") Long id){
        String message1 = EnstituService.getEnstituById(id).getBolumEnstituId().toString();
        EnstituService.deleteEnstitu(id);
        return ResponseEntity.ok(new GenericResponse(message1+"Deleted"));
    }

    @GetMapping("v1/enstitu/slice")
    public ResponseEntity<List<EnstituViewDTO>> slice(Pageable pageable){
        final List<EnstituViewDTO> Enstitus = EnstituService.slice(pageable);
        return ResponseEntity.ok(Enstitus);
    }

}
