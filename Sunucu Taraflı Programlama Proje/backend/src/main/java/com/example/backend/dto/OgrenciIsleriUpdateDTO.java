package com.example.backend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OgrenciIsleriUpdateDTO {

        private Long ogrenciOgrIsleriId;
        private String ogrenciIsleriAd;
        private String ogrenciIsleriSoyad;
        private String ogrenciIsleriEmail;
        private String ogrenciIsleriTelNo;
        private Date ogrenciIsleriGirisTarihi;
        private Date ogrenciIsleriDogumGun;
        private String ogrenciIsleriKimlikNo;
}
