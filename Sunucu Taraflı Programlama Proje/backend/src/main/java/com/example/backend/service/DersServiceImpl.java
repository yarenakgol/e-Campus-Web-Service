package com.example.backend.service;

import com.example.backend.dto.DersCreateDTO;
import com.example.backend.dto.DersUpdateDTO;
import com.example.backend.dto.DersViewDTO;
import com.example.backend.exception.NotFoundException;
import com.example.backend.repository.DersRepository;
import com.example.backend.validator.model.Ders;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author KadirRA
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class DersServiceImpl implements DersService {

	private final DersRepository dersRepository;

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public DersViewDTO getDersById(Long id) {
		final Ders ders = dersRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
		return DersViewDTO.of(ders);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<DersViewDTO> getDerss() {
		return dersRepository.findAll().stream().map(DersViewDTO::of).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public DersViewDTO createDers(DersCreateDTO dersCreateDTO) {
		final Ders ders = dersRepository
				.save(new Ders(dersCreateDTO.getName(),dersCreateDTO.getDonemadi(),dersCreateDTO.getKredi(),dersCreateDTO.getAkts()));
		//dersCreateDTO.getOgrenciid(), dersCreateDTO.getBolumid(), dersCreateDTO.getDonemid(),
		return DersViewDTO.of(ders);
	}

	@Override
	@Transactional
	public DersViewDTO updateDers(Long id, DersUpdateDTO dersUpdateDTO) {
		final Ders ders = dersRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
		ders.setOgrenciIsleri(ders.getOgrenciIsleri());
		ders.setBolum(ders.getBolum());
		ders.setDonem(ders.getDonem());
		ders.setName(dersUpdateDTO.getName());
		ders.setDonemadi(dersUpdateDTO.getDonemadi());
		ders.setKredi(dersUpdateDTO.getKredi());
		ders.setAkts(dersUpdateDTO.getAkts());

		final Ders updatedDers = dersRepository.save(ders);
		return DersViewDTO.of(updatedDers);
	}

	@Override
	@Transactional
	public void deleteDers(Long id) {
		final Ders ders = dersRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
		dersRepository.deleteById(ders.getId());
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<DersViewDTO> slice(Pageable pageable) {
		return dersRepository.findAll(pageable).stream().map(DersViewDTO::of).collect(Collectors.toList());
	}

}
