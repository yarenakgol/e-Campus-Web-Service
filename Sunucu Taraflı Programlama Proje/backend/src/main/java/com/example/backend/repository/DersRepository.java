package com.example.backend.repository;

import com.example.backend.validator.model.Ders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DersRepository extends JpaRepository<Ders, Long> {

	default boolean existsDersByid(Long id) {
		return false;
	}


}
