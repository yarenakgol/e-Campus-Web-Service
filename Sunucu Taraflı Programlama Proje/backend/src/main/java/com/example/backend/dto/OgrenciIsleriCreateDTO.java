package com.example.backend.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.backend.validator.UniqueOgrNo;
import com.example.backend.validator.UniquePhoneNo;
import com.example.backend.validator.UniqueUserName;

import com.example.backend.validator.UniqueeMail;
import java.util.Date;
import lombok.Data;
@Data
public class OgrenciIsleriCreateDTO {
        private Long ogrenciOgrIsleriId;
        private String ogrenciIsleriAd;
        private String ogrenciIsleriSoyad;
        private String ogrenciIsleriEmail;
        private String ogrenciIsleriTelNo;
        private Date ogrenciIsleriGirisTarihi;
        private Date ogrenciIsleriDogumGun;
        private String ogrenciIsleriKimlikNo;
}
