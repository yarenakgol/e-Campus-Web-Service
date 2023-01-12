package com.example.backend.dto;

import com.example.backend.validator.model.OgrenciIsleri;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@Getter
public final class OgrenciIsleriViewDTO implements Serializable {
        private static final long serialVersionUID = 1L;
        private Long ogrenciOgrIsleriId;
        private String ogrenciIsleriAd;
        private String ogrenciIsleriSoyad;
        private String ogrenciIsleriEmail;
        private String ogrenciIsleriTelNo;
        private Date ogrenciIsleriGirisTarihi;
        private Date ogrenciIsleriDogumGun;
        private String ogrenciIsleriKimlikNo;
        private OgrenciIsleriViewDTO(Long ogrenciOgrIsleriId,String ogrenciIsleriAd, String ogrenciIsleriSoyad, String ogrenciIsleriEmail, String ogrenciIsleriTelNo, Date ogrenciIsleriGirisTarihi, Date ogrenciIsleriDogumGun,  String ogrenciIsleriKimlikNo) {
                this.ogrenciOgrIsleriId=ogrenciOgrIsleriId;
                this.ogrenciIsleriAd = ogrenciIsleriAd;
                this.ogrenciIsleriSoyad = ogrenciIsleriSoyad;
                this.ogrenciIsleriEmail = ogrenciIsleriEmail;
                this.ogrenciIsleriTelNo = ogrenciIsleriTelNo;
                this.ogrenciIsleriGirisTarihi=ogrenciIsleriGirisTarihi;
                this.ogrenciIsleriDogumGun=ogrenciIsleriDogumGun;
                this.ogrenciIsleriKimlikNo= ogrenciIsleriKimlikNo;

        }
        public static OgrenciIsleriViewDTO of(OgrenciIsleri ogrenciIsleri){
                return new OgrenciIsleriViewDTO(ogrenciIsleri.getOgrenciOgrIsleriId(),ogrenciIsleri.getOgrenciIsleriAd(), ogrenciIsleri.getOgrenciIsleriSoyad(), ogrenciIsleri.getOgrenciIsleriEmail(), ogrenciIsleri.getOgrenciIsleriTelNo(), ogrenciIsleri.getOgrenciIsleriGirisTarihi(),ogrenciIsleri.getOgrenciIsleriDogumGun(), ogrenciIsleri.getOgrenciIsleriKimlikNo());
        }
}
