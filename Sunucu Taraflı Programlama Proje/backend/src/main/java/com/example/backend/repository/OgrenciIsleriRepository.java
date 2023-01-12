package com.example.backend.repository;

import com.example.backend.validator.model.OgrenciIsleri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OgrenciIsleriRepository extends JpaRepository<OgrenciIsleri, Long> {

	default boolean existsOgrenciIsleriById(Long id) {
		return false;
	}


}
