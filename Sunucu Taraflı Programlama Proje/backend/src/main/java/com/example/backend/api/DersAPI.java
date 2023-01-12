package com.example.backend.api;

import com.example.backend.dto.DersCreateDTO;
import com.example.backend.dto.DersUpdateDTO;
import com.example.backend.dto.DersViewDTO;
import com.example.backend.service.DersService;
import com.example.backend.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 
 * @author KadirRA
 * @since 1.0
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DersAPI {

	private final DersService dersService;

	@GetMapping("v1/ders/{id}")
	public ResponseEntity<DersViewDTO> getDersById(@PathVariable("id") Long id) {
		final DersViewDTO ders = dersService.getDersById(id);
		return ResponseEntity.ok(ders);
	}

	@GetMapping("v1/ders")
	public ResponseEntity<List<DersViewDTO>> getDerss() {
		final List<DersViewDTO> derss = dersService.getDerss();
		return ResponseEntity.ok(derss);
	}

	@PostMapping("v1/ders")
	public ResponseEntity<?> createDers(@Valid @RequestBody DersCreateDTO dersCreateDTO) {
		dersService.createDers(dersCreateDTO);
		return ResponseEntity.ok(new GenericResponse("Ders "+dersCreateDTO.getName()+" Created."));
	}

	@PutMapping("v1/ders/{id}")
	public ResponseEntity<DersViewDTO> updateDers(@Valid @PathVariable("id") Long id,
			@RequestBody DersUpdateDTO dersUpdateDTO) {
		final DersViewDTO ders = dersService.updateDers(id, dersUpdateDTO);
		return ResponseEntity.ok(ders);
	}

	@DeleteMapping("v1/ders/{id}")
	public ResponseEntity<?> deleteDers(@PathVariable("id") Long id) {
		String message1 = dersService.getDersById(id).getName();
		dersService.deleteDers(id);
		return ResponseEntity.ok(new GenericResponse(message1+" Deleted !"));
	}

	// More performance
	@GetMapping("v1/ders/slice")
	public ResponseEntity<List<DersViewDTO>> slice(Pageable pageable) {
		final List<DersViewDTO> derss = dersService.slice(pageable);
		return ResponseEntity.ok(derss);
	}
	
}
