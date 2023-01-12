package com.example.backend.validator.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ders")

public class Ders {

    @Id
    @Column(name = "ders_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "OgrenciIsleri_id")
    private OgrenciIsleri ogrenciIsleri;


    @ManyToOne
    @JoinColumn(name = "bolum_id")
    private Bolum bolum;

    @ManyToOne
    @JoinColumn(name = "donem_id")
    private Donem donem;

    @Column(name = "name")
    private String name;

    @Column(name="donemadi")
    private String donemadi;


    @Column(name = "kredi")
    private Integer kredi;

    @Column(name = "akts")
    private Integer akts;
    public Ders(String name, String donemadi, Integer kredi,Integer akts) {

        this.name = name;
        this.donemadi = donemadi;
        this.kredi = kredi;
        this.akts = akts;
    }
}
