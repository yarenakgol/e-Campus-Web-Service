package com.example.backend.dto;

import com.example.backend.validator.model.FakulteYonetim;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@Getter
public final class FakulteYonetimViewDTO implements Serializable {
        private static final long serialVersionUID = 1L;
        private Long personelFakYonId;
        private Long bolumFakYonId;
        private String fakulteYonetimAd;
        private String fakulteYonetimSoyad;
        private String fakulteYonetimEmail;
        private Long fakulteYonetimTelNo;
        private Date fakulteYonetimGirisTarihi;
        private Date fakulteYonetimDogumGun;
        private Long fakulteYonetimKimlikNo;
        private FakulteYonetimViewDTO(Long bolumFakYonId, Long personelFakYonId, String fakulteYonetimAd, String fakulteYonetimSoyad, String fakulteYonetimEmail, Long fakulteYonetimTelNo, Date fakulteYonetimGirisTarihi, Date fakulteYonetimDogumGun, Long fakulteYonetimKimlikNo) {
                this.bolumFakYonId=bolumFakYonId;
                this.personelFakYonId=personelFakYonId;
                this.fakulteYonetimAd = fakulteYonetimAd;
                this.fakulteYonetimSoyad = fakulteYonetimSoyad;
                this.fakulteYonetimEmail = fakulteYonetimEmail;
                this.fakulteYonetimTelNo = fakulteYonetimTelNo;
                this.fakulteYonetimGirisTarihi=fakulteYonetimGirisTarihi;
                this.fakulteYonetimDogumGun=fakulteYonetimDogumGun;
                this.fakulteYonetimKimlikNo= fakulteYonetimKimlikNo;

        }
        public static FakulteYonetimViewDTO of(FakulteYonetim fakulteYonetim){
                return new FakulteYonetimViewDTO(fakulteYonetim.getBolumFakYonId(),fakulteYonetim.getPersonelFakYonId(),fakulteYonetim.getFakulteYonetimAd(), fakulteYonetim.getFakulteYonetimSoyad(), fakulteYonetim.getFakulteYonetimEmail(), fakulteYonetim.getFakulteYonetimTelNo(), fakulteYonetim.getFakulteYonetimGirisTarihi(),fakulteYonetim.getFakulteYonetimDogumGun(), fakulteYonetim.getFakulteYonetimKimlikNo());
        }
}
