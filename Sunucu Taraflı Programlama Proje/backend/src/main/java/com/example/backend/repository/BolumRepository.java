package com.example.backend.repository;

import com.example.backend.validator.model.Bolum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BolumRepository extends JpaRepository<Bolum, Long> {

    default boolean existsBolumBybolumID(Long bolumID) {
        return false;
    }


}
