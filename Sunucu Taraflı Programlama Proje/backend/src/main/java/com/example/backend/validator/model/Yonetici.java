package com.example.backend.validator.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "yonetici")
public class Yonetici {
    @Id
    @Column(name = "yonetici_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long yoneticiID;

    @ManyToOne
    @JoinColumn(name="fakulte_id")
    private Fakulte fakulteID;

    @ManyToOne
    @JoinColumn(name="enstitu_Id")
    private Enstitu enstituId;

    @ManyToOne
    @JoinColumn(name="bolum_Id")
    private Bolum bolumID;

    @ManyToOne
    @JoinColumn(name="personel_Id")
    private Personel personelID;
    @Column(name = "yonetici_Ad")
    private String yoneticiAd;

    @Column(name = "yonetici_Soyad")
    private String yoneticiSoyad;

    @Column(name = "yonetici_email")
    private String yoneticiEmail;

    @Column(name = "yonetici_telno")
    private Long  yoneticiTelNo;

    @Column(name = "yonetici_giristarihi")
    private Date yoneticiGirisTarihi;
    @Column(name = "yonetici_dogumgun")
    private Date  yoneticiDogumGun;

    @Column(name = "yonetici_kimlikno")
    private Long  yoneticiKimlikNo;


    public Yonetici(Long fakulteID, Long enstituId, Long bolumID, Long personelID, String yoneticiAd, String yoneticiSoyad, String yoneticiEmail, Long yoneticiTelNo, Date yoneticiGirisTarihi, Date yoneticiDogumGun, Long yoneticiKimlikNo) {

        this.fakulteID = getFakulteID();
        this.enstituId = getEnstituId();
        this.bolumID = getBolumID();
        this.personelID = getPersonelID();
        this.yoneticiAd = yoneticiAd;
        this.yoneticiSoyad = yoneticiSoyad;
        this.yoneticiEmail = yoneticiEmail;
        this.yoneticiTelNo = yoneticiTelNo;
        this.yoneticiGirisTarihi = yoneticiGirisTarihi;
        this.yoneticiDogumGun = yoneticiDogumGun;
        this.yoneticiKimlikNo = yoneticiKimlikNo;
    }
}
