package com.example.backend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class FakulteYonetimCreateDTO {
        private Long bolumFakYonId;
        private Long personelFakYonId;
        private String fakulteYonetimAd;
        private String fakulteYonetimSoyad;
        private String fakulteYonetimEmail;
        private Long fakulteYonetimTelNo;
        private Date fakulteYonetimGirisTarihi;
        private Date fakulteYonetimDogumGun;
        private Long fakulteYonetimKimlikNo;

}
