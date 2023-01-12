package com.example.backend.repository;

import com.example.backend.validator.model.FakulteYonetim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FakulteYonetimRepository extends JpaRepository<FakulteYonetim, Long> {

    default boolean existsFakulteYonetimByID(Long ID) {
        return false;
    }


}
