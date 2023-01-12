package com.example.backend.validator.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Donem")

public class Donem {

    @Id
    @Column(name = "donem_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name")
    private String name;

    @Column(name = "KrediToplam")
    private Integer KrediToplam;
    public Donem(String name, Integer KrediToplam) {
        this.name = name;
        this.KrediToplam = KrediToplam;
    }


}
