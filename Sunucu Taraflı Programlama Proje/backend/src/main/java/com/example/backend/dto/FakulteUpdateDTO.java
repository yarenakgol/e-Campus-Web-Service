package com.example.backend.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class FakulteUpdateDTO {
    @NotNull(message = "{backend.constraints.firstname.NotNull.message}")
    @Size(min = 1, max = 30, message = "{backend.constraints.firstname.Size.message}")
    private String fakulteAd;

}
