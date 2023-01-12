package com.example.backend.repository;

import com.example.backend.validator.model.Fakulte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FakulteRepository extends JpaRepository<Fakulte, Long> {

    default boolean existsFakulteBypersonelID(Long fakulteID) {
        return false;
    }


}
