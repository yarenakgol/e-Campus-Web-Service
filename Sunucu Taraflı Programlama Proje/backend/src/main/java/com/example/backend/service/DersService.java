package com.example.backend.service;

import com.example.backend.dto.DersCreateDTO;
import com.example.backend.dto.DersUpdateDTO;
import com.example.backend.dto.DersViewDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 
 * @author KadirRA
 * @since 1.0
 */
public interface DersService {

	DersViewDTO getDersById(Long id);

	List<DersViewDTO> getDerss();

	DersViewDTO createDers(DersCreateDTO dersCreateDTO);

	DersViewDTO updateDers(Long id, DersUpdateDTO dersUpdateDTO);

	void deleteDers(Long id);

	List<DersViewDTO> slice(Pageable pageable);

}
