package com.example.backend.dto;

import com.example.backend.validator.model.Bolum;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class BolumViewDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String bolumAd;

    private BolumViewDTO(String bolumAd)
    {
        this.bolumAd = bolumAd;
           }
    public  static BolumViewDTO of(Bolum bolum){
        return new BolumViewDTO(bolum.getBolumAd());
    }

}
