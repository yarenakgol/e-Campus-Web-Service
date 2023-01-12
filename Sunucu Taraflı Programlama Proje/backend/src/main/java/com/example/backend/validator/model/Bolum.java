package com.example.backend.validator.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@Entity
@Table(name = "bolum")


public class Bolum {

    @Id
    @Column(name = "bolum_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "OgrenciIsleri_id")
    private OgrenciIsleri ogrenciIsleriID;

    @Column(name = "bolum_ad")
    private  String bolumAd;

    public Bolum( String bolumAd) {

        this.bolumAd= bolumAd;

    }

}
