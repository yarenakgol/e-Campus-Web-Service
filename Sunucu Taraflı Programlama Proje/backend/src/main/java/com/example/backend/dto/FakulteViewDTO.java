package com.example.backend.dto;

import com.example.backend.validator.model.Fakulte;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class FakulteViewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String fakulteAd;
    private FakulteViewDTO(String fakulteAd)
    {
        this.fakulteAd = fakulteAd;
           }
    public  static FakulteViewDTO of(Fakulte fakulte){
        return new FakulteViewDTO(fakulte.getFakulteAd());
    }

}
