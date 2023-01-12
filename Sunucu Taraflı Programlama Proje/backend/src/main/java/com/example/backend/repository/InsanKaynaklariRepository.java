package com.example.backend.repository;

import com.example.backend.validator.model.InsanKaynaklari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsanKaynaklariRepository extends JpaRepository<InsanKaynaklari, Long> {

    default boolean existsInsanKaynaklariByKimlikNo(Long insanKaynaklariKimlikNo) {
        return false;
    }


}
