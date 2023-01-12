package com.example.backend.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class YoneticiUpdateDTO {
    private Long yoneticiID;

    @NotNull(message = "")
    @Size(min = 1, max = 30, message = "")
    private String yoneticiAd;

    @NotNull(message = "")
    @Size(min = 1,max = 30, message = "")
    private String yoneticiSoyad;

    @NotNull(message = "")
    @Size(min = 3,max = 30,message = "")
    private String yoneticiEmail;

    private Long yoneticiTelNo;
    private Date yoneticiGirisTarihi;
    private Date yoneticiDogumGun;
    private Long yoneticiKimlikNo;
}
