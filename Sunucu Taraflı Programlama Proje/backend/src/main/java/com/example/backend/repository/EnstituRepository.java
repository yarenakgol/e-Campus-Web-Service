package com.example.backend.repository;

import com.example.backend.validator.model.Enstitu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnstituRepository extends JpaRepository<Enstitu, Long> {

    default boolean existsEnstituByID(Long ID) {
        return false;
    }


}
