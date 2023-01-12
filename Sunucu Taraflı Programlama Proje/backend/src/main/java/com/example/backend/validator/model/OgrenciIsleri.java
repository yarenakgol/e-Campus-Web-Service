package com.example.backend.validator.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ogrenciIsleri")
public class OgrenciIsleri {
    @Id
    @Column(name = "OgrenciIsleri_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="ogrenciOgrIsleri_Id",nullable = false)
    private Long ogrenciOgrIsleriId;
    @Column(name = "ogrenciIsleri_Ad", nullable = false, length = 30)
    private String ogrenciIsleriAd;

    @Column(name = "ogrenciIsleri_Soyad", nullable = false, length = 30)
    private String ogrenciIsleriSoyad;

    @Column(name = "ogrenciIsleri_email", nullable = false, length = 50, unique = true)
    private String ogrenciIsleriEmail;

    @Column(name = "ogrenciIsleri_telno", nullable = false, length = 11)
    private String  ogrenciIsleriTelNo;

    @Column(name = "ogrenciIsleri_giristarihi", nullable = false, length = 10)
    private Date ogrenciIsleriGirisTarihi;
    @Column(name = "ogrenciIsleri_dogumgun", nullable = false, length = 10)
    private Date  ogrenciIsleriDogumGun;

    @Column(name = "ogrenciIsleri_kimlikno", nullable = false, length = 11, unique = true)
    private String  ogrenciIsleriKimlikNo;

    public OgrenciIsleri(Long ogrenciOgrIsleriId, String ogrenciIsleriAd, String ogrenciIsleriSoyad, String ogrenciIsleriEmail,String ogrenciIsleriTelNo,Date ogrenciIsleriGirisTarihi, Date ogrenciIsleriDogumGun, String ogrenciIsleriKimlikNo)
    {
        this.ogrenciOgrIsleriId = ogrenciOgrIsleriId;
        this.ogrenciIsleriAd = ogrenciIsleriAd;
        this.ogrenciIsleriSoyad = ogrenciIsleriSoyad;
        this.ogrenciIsleriEmail = ogrenciIsleriEmail;
        this.ogrenciIsleriTelNo = ogrenciIsleriTelNo;
        this.ogrenciIsleriGirisTarihi = ogrenciIsleriGirisTarihi;
        this.ogrenciIsleriDogumGun = ogrenciIsleriDogumGun;
        this.ogrenciIsleriKimlikNo = ogrenciIsleriKimlikNo;
    }
}
