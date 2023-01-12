package com.example.backend.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class FakulteCreateDTO {
    @NotNull(message = "{backend.constraints.firstname.NotNull.message}")
    @Size(min = 1, max = 40, message = "{backend.constraints.firstname.Size.message}")
    private String fakulteAd;

}
