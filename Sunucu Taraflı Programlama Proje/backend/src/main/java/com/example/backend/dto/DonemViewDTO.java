package com.example.backend.dto;

import com.example.backend.validator.model.Donem;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class DonemViewDTO implements Serializable {
    private static final long serialVersionUID = 1L;
       private String name;
    private Integer KrediToplam;

    private DonemViewDTO(String name,Integer KrediToplam)
    {

        this.name = name;
        this.KrediToplam=KrediToplam;
           }
    public  static DonemViewDTO of(Donem donem){
        return new DonemViewDTO( donem.getName(),donem.getKrediToplam());
    }

}
