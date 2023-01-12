package com.example.backend.validator.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "fakulteYonetim")
public class FakulteYonetim {
    @Id
    @Column(name = "FakulteYonetim_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name="bolumFakYon_Id",nullable = false)
    private Long bolumFakYonId;
    @Column(name="personelFakYon_Id",nullable = false)
    private Long personelFakYonId;
    @Column(name = "fakulteYonetim_Ad",nullable = false,length = 30)
    private String fakulteYonetimAd;

    @Column(name = "fakulteYonetim_Soyad", nullable = false,length = 30)
    private String fakulteYonetimSoyad;

    @Column(name = "fakulteYonetim_email", nullable = false, length = 50, unique = true)
    private String fakulteYonetimEmail;

    @Column(name = "fakulteYonetim_telno", nullable = false, unique = true)
    private Long  fakulteYonetimTelNo;

    @Column(name = "fakulteYonetim_giristarihi")
    private Date fakulteYonetimGirisTarihi;
    @Column(name = "fakulteYonetim_dogumgun")
    private Date  fakulteYonetimDogumGun;

    @Column(name = "fakulteYonetim_kimlikno", nullable = false, length = 11, unique = true)
    private Long  fakulteYonetimKimlikNo;

    public FakulteYonetim(Long bolumFakYonId,Long personelFakYonId, String fakulteYonetimAd, String fakulteYonetimSoyad, String fakulteYonetimEmail, Long fakulteYonetimTelNo, Date fakulteYonetimGirisTarihi, Date fakulteYonetimDogumGun, Long fakulteYonetimKimlikNo)
    {
        this.personelFakYonId = personelFakYonId;
        this.bolumFakYonId = bolumFakYonId;
        this.fakulteYonetimAd = fakulteYonetimAd;
        this.fakulteYonetimSoyad = fakulteYonetimSoyad;
        this.fakulteYonetimEmail = fakulteYonetimEmail;
        this.fakulteYonetimTelNo = fakulteYonetimTelNo;
        this.fakulteYonetimGirisTarihi = fakulteYonetimGirisTarihi;
        this.fakulteYonetimDogumGun = fakulteYonetimDogumGun;
        this.fakulteYonetimKimlikNo = fakulteYonetimKimlikNo;
    }
}