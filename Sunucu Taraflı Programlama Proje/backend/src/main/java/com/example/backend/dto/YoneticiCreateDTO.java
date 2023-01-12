package com.example.backend.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class YoneticiCreateDTO {
    @NotNull(message = "")
    private Long fakulteID;
    @NotNull(message = "")
    private Long enstituId;
    @NotNull(message = "")
    private Long bolumID;
    @NotNull
    private Long personelID;
    @NotNull(message = "{backend.constraints.firstname.NotNull.message}")
    @Size(min = 1, max = 30, message = "{backend.constraints.firstname.Size.message}")
    private String yoneticiAd;
    @NotNull(message = "{backend.constraints.firstname.NotNull.message}")
    @Size(min = 1, max = 30, message = "{backend.constraints.firstname.Size.message}")
    private String yoneticiSoyad;
    @NotNull(message = "{backend.constraints.firstname.NotNull.message}")
    @Size(min = 1, max = 30, message = "{backend.constraints.firstname.Size.message}")
    private String yoneticiEmail;
    private  Long yoneticiTelNo;
    private Date yoneticiGirisTarihi;
    private Date yoneticiDogumGun;
    private Long yoneticiKimlikNo;
}
