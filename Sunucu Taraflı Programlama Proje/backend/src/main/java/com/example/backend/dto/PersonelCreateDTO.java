package com.example.backend.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class PersonelCreateDTO {
    @NotNull(message = "{backend.constraints.firstname.NotNull.message}")
    @Size(min = 1, max = 30, message = "{backend.constraints.firstname.Size.message}")
    private String Personel_Name;
    @NotNull(message = "{backend.constraints.firstname.NotNull.message}")
    @Size(min = 1, max = 30, message = "{backend.constraints.firstname.Size.message}")
    private String Personel_LastName;
    @NotNull(message = "{backend.constraints.firstname.NotNull.message}")
    @Size(min = 1, max = 30, message = "{backend.constraints.firstname.Size.message}")
    private String Personel_Gorev;
}
