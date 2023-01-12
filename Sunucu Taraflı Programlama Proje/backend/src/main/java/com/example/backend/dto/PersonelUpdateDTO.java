package com.example.backend.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class PersonelUpdateDTO {

    @NotNull(message = "")
    @Size(min = 1, max = 30, message = "")
    private String Personel_Name;

    @NotNull(message = "")
    @Size(min = 1,max = 30, message = "")
    private String Personel_LastName;

    @NotNull(message = "")
    @Size(min = 3,max = 30,message = "")
    private String Personel_Gorev;

}
