package com.example.backend.repository;

import com.example.backend.validator.model.Yonetici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YoneticiRepository extends JpaRepository<Yonetici, Long> {
    default  boolean existsYoneticiByYoneticiKimlikNo(Long yoneticiKimlikNo){
        return false;
    }
}
