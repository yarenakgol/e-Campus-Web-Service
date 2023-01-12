package com.example.backend.validator.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
@Entity
@Table(name = "personel")
public class Personel{

    @Id
    @Column(name = "personel_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long personelID;

    @Column(name = "personel_name")
    public String Personel_Name;

    @Column(name = "personel_lastName")
    public String Personel_LastName;

    @Column(name = "personel_gorev")
    public String Personel_Gorev;

    public Personel(String Personel_Name, String Personel_LastName, String Personel_Gorev) {

        this.Personel_Name = Personel_Name;
        this.Personel_LastName= Personel_LastName;
        this.Personel_Gorev = Personel_Gorev;

    }
}
