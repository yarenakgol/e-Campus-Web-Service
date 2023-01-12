package com.example.backend.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class BolumCreateDTO {

    private Long ogrenciIsleriID;
    private String bolumAd;

}
