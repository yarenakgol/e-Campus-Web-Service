package com.example.backend.repository;

import com.example.backend.validator.model.Personel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonelRepository extends JpaRepository<Personel, Long> {

    default boolean existsPersonelBypersonelID(Long personelID) {
        return false;
    }


}
