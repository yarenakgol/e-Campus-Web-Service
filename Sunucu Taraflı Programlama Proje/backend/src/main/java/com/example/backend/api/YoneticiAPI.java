package com.example.backend.api;
import org.springframework.data.domain.Pageable;
import com.example.backend.dto.YoneticiCreateDTO;
import com.example.backend.dto.YoneticiUpdateDTO;
import com.example.backend.dto.YoneticiViewDTO;
import com.example.backend.service.YoneticiService;
import com.example.backend.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class YoneticiAPI {
    private final YoneticiService YoneticiService;
    @GetMapping("v1/yonetici/{id}")
    public ResponseEntity<YoneticiViewDTO> getYoneticiById(@PathVariable("id") Long id){
        final YoneticiViewDTO Yonetici = YoneticiService.getYoneticiById(id);
        return ResponseEntity.ok(Yonetici);
    }

    @GetMapping("v1/yonetici")
    public ResponseEntity<List<YoneticiViewDTO>> getYoneticis(){
        final List<YoneticiViewDTO> Yoneticis = YoneticiService.getYoneticis();
        return ResponseEntity.ok(Yoneticis);
    }

    @PostMapping("v1/yonetici")
    public ResponseEntity<?> createYonetici(@Valid @RequestBody YoneticiCreateDTO YoneticiCreateDTO){
        YoneticiService.createYonetici(YoneticiCreateDTO);
        return ResponseEntity.ok(new GenericResponse("Yonetici "+YoneticiCreateDTO.getYoneticiAd()+YoneticiCreateDTO.getYoneticiSoyad()+"Created."));
    }

    @PutMapping("v1/yonetici/{id}")
    public ResponseEntity<YoneticiViewDTO> updateYonetici(@Valid @PathVariable("id")Long id,
                                                          @RequestBody YoneticiUpdateDTO YoneticiUpdateDTO){
        final YoneticiViewDTO Yonetici = YoneticiService.updateYonetici(id, YoneticiUpdateDTO);
        return ResponseEntity.ok(Yonetici);
    }
    @DeleteMapping("v1/yonetici/{id}")
    public ResponseEntity<?> deleteYonetici(@PathVariable("id") Long id){
        String message1 = YoneticiService.getYoneticiById(id).getYoneticiAd();
        YoneticiService.deleteYonetici(id);
        return ResponseEntity.ok(new GenericResponse(message1+"Deleted"));
    }

    @GetMapping("v1/yonetici/slice")
    public ResponseEntity<List<YoneticiViewDTO>> slice(Pageable pageable){
        final List<YoneticiViewDTO> Yoneticis = YoneticiService.slice(pageable);
        return ResponseEntity.ok(Yoneticis);
    }

}
