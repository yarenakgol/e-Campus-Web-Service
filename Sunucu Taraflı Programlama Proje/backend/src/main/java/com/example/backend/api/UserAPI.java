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

import com.example.backend.dto.UserCreateDTO;
import com.example.backend.dto.UserUpdateDTO;
import com.example.backend.dto.UserViewDTO;
import com.example.backend.service.UserService;
import com.example.backend.shared.GenericResponse;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author KadirRA
 * @since 1.0
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserAPI {

	private final UserService userService;

	@GetMapping("v1/ogrenci/{id}")
	public ResponseEntity<UserViewDTO> getUserById(@PathVariable("id") Long id) {
		final UserViewDTO user = userService.getUserById(id);
		return ResponseEntity.ok(user);
	}

	@GetMapping("v1/ogrenci")
	public ResponseEntity<List<UserViewDTO>> getUsers() {
		final List<UserViewDTO> users = userService.getUsers();
		return ResponseEntity.ok(users);
	}

	@PostMapping("v1/ogrenci")
	public ResponseEntity<?> createUser(@Valid @RequestBody UserCreateDTO userCreateDTO) {
		userService.createUser(userCreateDTO);
		return ResponseEntity.ok(new GenericResponse("User "+userCreateDTO.getUserName()+" Created."));
	}

	@PutMapping("v1/ogrenci/{id}")
	public ResponseEntity<UserViewDTO> updateUser(@Valid @PathVariable("id") Long id,
			@RequestBody UserUpdateDTO userUpdateDTO) {
		final UserViewDTO user = userService.updateUser(id, userUpdateDTO);
		return ResponseEntity.ok(user);
	}

	@DeleteMapping("v1/ogrenci/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
		String message1 = userService.getUserById(id).getUserName();
		userService.deleteUser(id);
		return ResponseEntity.ok(new GenericResponse(message1+" Deleted !"));
	}

	// More performance
	@GetMapping("v1/ogrenci/slice")
	public ResponseEntity<List<UserViewDTO>> slice(Pageable pageable) {
		final List<UserViewDTO> users = userService.slice(pageable);
		return ResponseEntity.ok(users);
	}
	
}
