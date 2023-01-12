package com.example.backend.dto;

import com.example.backend.validator.UniquePhoneNo;
import com.example.backend.validator.UniqueeMail;
import lombok.Data;

import javax.validation.Constraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
@Data
public class InsanKaynaklariUpdateDTO {

    //private Long personelID;

    @NotNull(message = "{backend.constraints.firstname.NotNull.message}")
    @Size(min = 1, max = 30, message = "{backend.constraints.firstname.Size.message}")
    private String insanKaynaklariAd;

    @NotNull(message = "{backend.constraints.lastname.NotNull.message}")
    @Size(min = 1, max = 30, message = "{backend.constraints.lastname.Size.message}")
    private String insanKaynaklariSoyad;

    @NotNull(message = "{backend.constraints.email.Size.message}")
    @Size(min=3, max=50, message ="{backend.constraints.email.NotNull.message}")
    @UniqueeMail
    private String insanKaynaklariEmail;

    //@NotNull(message = "{backend.constraints.phoneNum.Size.message}")
    //@Size(min=10, max=15, message ="{backend.constraints.phoneNum.NotNull.message}")
    //@UniquePhoneNo
    private Long insanKaynaklariTelNo;

    //@NotNull(message = "")
    private Date insanKaynaklariGirisTarihi;

    //@NotNull(message = "")
    private Date insanKaynaklariDogumGun;

    //@NotNull(message = "")
    //@Size(min = 10, max = 12, message = "")
    private Long insanKaynaklariKimlikNo;

}
