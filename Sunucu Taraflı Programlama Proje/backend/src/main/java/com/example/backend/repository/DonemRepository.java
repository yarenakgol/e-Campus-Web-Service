package com.example.backend.repository;

import com.example.backend.validator.model.Donem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonemRepository extends JpaRepository<Donem, Long> {

    default boolean existsDonemByID(Long ID) {
        return false;
    }


}
