package com.example.backend.dto;

import com.example.backend.validator.model.Yonetici;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@Getter
public class YoneticiViewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String yoneticiAd;
    private final String yoneticiSoyad;
    private final String yoneticiEmail;
    private final Long yoneticiTelNo;
    private final Date yoneticiGirisTarihi;
    private final Date yoneticiDogumGun;
    private final Long yoneticiKimlikNo;
    private YoneticiViewDTO(String yoneticiAd, String yoneticiSoyad, String yoneticiEmail, Long yoneticiTelNo, Date yoneticiGirisTarihi, Date yoneticiDogumGun, Long yoneticiKimlikNo)
    {
        this.yoneticiAd = yoneticiAd;
        this.yoneticiSoyad = yoneticiSoyad;
        this.yoneticiEmail = yoneticiEmail;
        this.yoneticiTelNo = yoneticiTelNo;
        this.yoneticiGirisTarihi = yoneticiGirisTarihi;
        this.yoneticiDogumGun = yoneticiDogumGun;
        this.yoneticiKimlikNo = yoneticiKimlikNo;
    }
    public  static YoneticiViewDTO of(Yonetici yonetici){
        return new YoneticiViewDTO(yonetici.getYoneticiAd(),yonetici.getYoneticiSoyad(), yonetici.getYoneticiEmail(), yonetici.getYoneticiTelNo(),yonetici.getYoneticiGirisTarihi(),yonetici.getYoneticiDogumGun(), yonetici.getYoneticiKimlikNo());
    }

}
