package com.example.backend.dto;

import com.example.backend.validator.model.Enstitu;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class EnstituViewDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long bolumEnstituId;
    private Long lisansEnstituId;
    private Long personelEnstituId;


    private EnstituViewDTO(Long bolumEnstituId,Long lisansEnstituId,Long personelEnstituId)
    {
        this.bolumEnstituId= bolumEnstituId;
        this.lisansEnstituId= lisansEnstituId;
        this.personelEnstituId= personelEnstituId;
           }
    public  static EnstituViewDTO of(Enstitu enstitu){
        return new EnstituViewDTO(enstitu.getBolumEnstituId(), enstitu.getLisansEnstituId(), enstitu.getPersonelEnstituId());
    }

}
