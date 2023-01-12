package com.example.backend.dto;

import com.example.backend.validator.model.Personel;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@Getter
public class PersonelViewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String personel_Name;
    private final String personel_LastName;
    private final String personel_Gorev;
    private PersonelViewDTO(String personel_Name, String personel_LastName, String personel_Gorev)
    {
        this.personel_Name = personel_Name;
        this.personel_LastName = personel_LastName;
        this.personel_Gorev = personel_Gorev;
           }
    public  static PersonelViewDTO of(Personel personel){
        return new PersonelViewDTO(personel.getPersonel_Name(),personel.getPersonel_LastName(), personel.Personel_Gorev);
    }

}
