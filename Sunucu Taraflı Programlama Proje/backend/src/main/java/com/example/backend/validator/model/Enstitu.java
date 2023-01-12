package com.example.backend.validator.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "enstitu")
public class Enstitu {

    @Id
    @Column(name = "EnstituId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bolumEnstitu_Id", nullable = false, length = 30, unique = true)
    private Long bolumEnstituId;

    @Column(name = "lisansEnstitu_Id", nullable = false, length = 30, unique = true)
    private Long lisansEnstituId;

    @Column(name = "personelEnstitu_Id", nullable = false, length = 30, unique = true)
    private Long personelEnstituId;


    public Enstitu(Long bolumEnstituId, Long lisansEnstituId, Long personelEnstituId) {
        this.bolumEnstituId = bolumEnstituId;
        this.lisansEnstituId = lisansEnstituId;
        this.personelEnstituId = personelEnstituId;
    }
}