package com.example.backend.validator.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "insanKaynaklari")
public class InsanKaynaklari {
    @Id
    @Column(name = "insanKaynaklari_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long insanKaynaklariID;

    @ManyToOne
    @JoinColumn(name = "personel_id")
    private Personel personelID;

    @Column(name = "insanKaynaklari_Ad")
    private String insanKaynaklariAd;

    @Column(name = "insanKaynaklari_Soyad")
    private String insanKaynaklariSoyad;

    @Column(name = "insanKaynaklari_email",unique = true)
    private String insanKaynaklariEmail;

    @Column(name = "insanKaynaklari_telno",unique = true)
    private Long insanKaynaklariTelNo;
    @Column(name = "insanKaynaklari_giristarihi",nullable = false)
    private Date insanKaynaklariGirisTarihi;
    @Column(name = "insanKaynaklari_dogumgun",nullable = false)
    private Date  insanKaynaklariDogumGun;
    @Column(name = "insanKaynaklari_kimlikno", unique = true)
    private Long  insanKaynaklariKimlikNo;


    public InsanKaynaklari(String insanKaynaklariAd, String insanKaynaklariSoyad, String insanKaynaklariEmail, Long insanKaynaklariTelNo, Date insanKaynaklariGirisTarihi, Date insanKaynaklariDogumGun, Long insanKaynaklariKimlikNo) {
        this.insanKaynaklariAd = insanKaynaklariAd;
        this.insanKaynaklariSoyad = insanKaynaklariSoyad;
        this.insanKaynaklariEmail = insanKaynaklariEmail;
        this.insanKaynaklariTelNo = insanKaynaklariTelNo;
        this.insanKaynaklariGirisTarihi = insanKaynaklariGirisTarihi;
        this.insanKaynaklariDogumGun = insanKaynaklariDogumGun;
        this.insanKaynaklariKimlikNo = insanKaynaklariKimlikNo;
    }

}
