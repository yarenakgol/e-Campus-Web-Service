package com.example.backend.dto;

import java.io.Serializable;
import java.util.Date;

import com.example.backend.validator.model.InsanKaynaklari;
import lombok.Getter;

@Getter
public final class InsanKaynaklariViewDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    //private final Long personelID;
    private final String insanKaynaklariAd;
    private final String insanKaynaklariSoyad;

    private final String insanKaynaklariEmail;
    private final Long insanKaynaklariTelNo;
    private final Date insanKaynakalariGirisTarihi;
    private final Date insanKaynakalariDogumGun;
    private final Long insanKaynaklariKimlikNo;

    private InsanKaynaklariViewDTO(String insanKaynakalariAd, String insanKaynakalariSoyad, String insanKaynakalariEmail, Long insanKaynakalariTelNo, Date insanKaynakalariGirisTarihi, Date insanKaynakalariDogumGun,  Long insanKaynaklariKimlikNo) {
       // this.personelID=personelID;
        this.insanKaynaklariAd = insanKaynakalariAd;
        this.insanKaynaklariSoyad = insanKaynakalariSoyad;
        this.insanKaynaklariEmail = insanKaynakalariEmail;
        this.insanKaynaklariTelNo = insanKaynakalariTelNo;
        this.insanKaynakalariGirisTarihi=insanKaynakalariGirisTarihi;
        this.insanKaynakalariDogumGun=insanKaynakalariDogumGun;
        this.insanKaynaklariKimlikNo= insanKaynaklariKimlikNo;

    }
    public static InsanKaynaklariViewDTO of(InsanKaynaklari insanKaynaklari){
        return new InsanKaynaklariViewDTO(insanKaynaklari.getInsanKaynaklariAd(), insanKaynaklari.getInsanKaynaklariSoyad(), insanKaynaklari.getInsanKaynaklariEmail(), insanKaynaklari.getInsanKaynaklariTelNo(), insanKaynaklari.getInsanKaynaklariGirisTarihi(),insanKaynaklari.getInsanKaynaklariDogumGun(), insanKaynaklari.getInsanKaynaklariKimlikNo());
    }

}
//tel ve şeyi int yaptık