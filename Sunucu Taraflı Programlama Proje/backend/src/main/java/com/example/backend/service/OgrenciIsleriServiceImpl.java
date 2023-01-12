package com.example.backend.service;

import com.example.backend.dto.OgrenciIsleriCreateDTO;
import com.example.backend.dto.OgrenciIsleriUpdateDTO;
import com.example.backend.dto.OgrenciIsleriViewDTO;
import com.example.backend.exception.NotFoundException;
import com.example.backend.repository.OgrenciIsleriRepository;
import com.example.backend.validator.model.OgrenciIsleri;
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
public class OgrenciIsleriServiceImpl implements OgrenciIsleriService {

	private final OgrenciIsleriRepository ogrenciIsleriRepository;

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public OgrenciIsleriViewDTO getOgrenciIsleriById(Long id) {
		final OgrenciIsleri ogrenciIsleri = ogrenciIsleriRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
		return OgrenciIsleriViewDTO.of(ogrenciIsleri);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<OgrenciIsleriViewDTO> getOgrenciIsleris() {
		return ogrenciIsleriRepository.findAll().stream().map(OgrenciIsleriViewDTO::of).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public OgrenciIsleriViewDTO createOgrenciIsleri(OgrenciIsleriCreateDTO ogrenciIsleriCreateDTO) {
		final OgrenciIsleri ogrenciIsleri = ogrenciIsleriRepository
				.save(new OgrenciIsleri(ogrenciIsleriCreateDTO.getOgrenciOgrIsleriId(),ogrenciIsleriCreateDTO.getOgrenciIsleriAd(), ogrenciIsleriCreateDTO.getOgrenciIsleriSoyad(), ogrenciIsleriCreateDTO.getOgrenciIsleriEmail(),ogrenciIsleriCreateDTO.getOgrenciIsleriTelNo(),ogrenciIsleriCreateDTO.getOgrenciIsleriGirisTarihi(),ogrenciIsleriCreateDTO.getOgrenciIsleriDogumGun(),ogrenciIsleriCreateDTO.getOgrenciIsleriKimlikNo()));
		return OgrenciIsleriViewDTO.of(ogrenciIsleri);
	}

	@Override
	@Transactional
	public OgrenciIsleriViewDTO updateOgrenciIsleri(Long id, OgrenciIsleriUpdateDTO ogrenciIsleriUpdateDTO) {
		final OgrenciIsleri ogrenciIsleri = ogrenciIsleriRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
		ogrenciIsleri.setOgrenciOgrIsleriId(ogrenciIsleriUpdateDTO.getOgrenciOgrIsleriId());
		ogrenciIsleri.setOgrenciIsleriAd(ogrenciIsleriUpdateDTO.getOgrenciIsleriAd());
		ogrenciIsleri.setOgrenciIsleriSoyad(ogrenciIsleriUpdateDTO.getOgrenciIsleriSoyad());
		ogrenciIsleri.setOgrenciIsleriEmail(ogrenciIsleriUpdateDTO.getOgrenciIsleriEmail());
		ogrenciIsleri.setOgrenciIsleriTelNo(ogrenciIsleriUpdateDTO.getOgrenciIsleriTelNo());
		ogrenciIsleri.setOgrenciIsleriGirisTarihi(ogrenciIsleriUpdateDTO.getOgrenciIsleriGirisTarihi());
		ogrenciIsleri.setOgrenciIsleriDogumGun(ogrenciIsleriUpdateDTO.getOgrenciIsleriDogumGun());
		ogrenciIsleri.setOgrenciIsleriKimlikNo(ogrenciIsleriUpdateDTO.getOgrenciIsleriKimlikNo());

		final OgrenciIsleri updatedOgrenciIsleri = ogrenciIsleriRepository.save(ogrenciIsleri);
		return OgrenciIsleriViewDTO.of(updatedOgrenciIsleri);
	}

	@Override
	@Transactional
	public void deleteOgrenciIsleri(Long id) {
		final OgrenciIsleri ogrenciIsleri = ogrenciIsleriRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
		ogrenciIsleriRepository.deleteById(ogrenciIsleri.getId());
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<OgrenciIsleriViewDTO> slice(Pageable pageable) {
		return ogrenciIsleriRepository.findAll(pageable).stream().map(OgrenciIsleriViewDTO::of).collect(Collectors.toList());
	}

}
