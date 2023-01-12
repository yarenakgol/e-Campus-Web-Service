package com.example.backend.api;

import com.example.backend.dto.DonemCreateDTO;
import com.example.backend.dto.DonemUpdateDTO;
import com.example.backend.dto.DonemViewDTO;
import com.example.backend.service.DonemService;
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
public class DonemAPI {
    private final DonemService DonemService;
    @GetMapping("v1/donem/{id}")
    public ResponseEntity<DonemViewDTO> getDonemById(@PathVariable("id") Long id){
        final DonemViewDTO Donem = DonemService.getDonemById(id);
        return ResponseEntity.ok(Donem);
    }

    @GetMapping("v1/donem")
    public ResponseEntity<List<DonemViewDTO>> getDonems(){
        final List<DonemViewDTO> Donems = DonemService.getDonems();
        return ResponseEntity.ok(Donems);
    }

    @PostMapping("v1/donem")
    public ResponseEntity<?> createDonem(@Valid @RequestBody DonemCreateDTO DonemCreateDTO){
        DonemService.createDonem(DonemCreateDTO);
        return ResponseEntity.ok(new GenericResponse("Donem "+DonemCreateDTO.getName()+" Created."));
    }

    @PutMapping("v1/donem/{id}")
    public ResponseEntity<DonemViewDTO> updateDonem(@Valid @PathVariable("id")Long id,
                                                          @RequestBody DonemUpdateDTO DonemUpdateDTO){
        final DonemViewDTO Donem = DonemService.updateDonem(id, DonemUpdateDTO);
        return ResponseEntity.ok(Donem);
    }
    @DeleteMapping("v1/donem/{id}")
    public ResponseEntity<?> deleteDonem(@PathVariable("id") Long id){
        String message1 = DonemService.getDonemById(id).getName();
        DonemService.deleteDonem(id);
        return ResponseEntity.ok(new GenericResponse(message1+"Deleted"));
    }

    @GetMapping("v1/donem/slice")
    public ResponseEntity<List<DonemViewDTO>> slice(Pageable pageable){
        final List<DonemViewDTO> Donems = DonemService.slice(pageable);
        return ResponseEntity.ok(Donems);
    }

}
