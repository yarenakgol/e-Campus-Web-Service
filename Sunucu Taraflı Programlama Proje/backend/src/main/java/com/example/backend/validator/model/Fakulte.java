package com.example.backend.validator.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "fakulte")
public class Fakulte {
    @Id
    @Column(name = "fakulte_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fakulteID;

    @Column(name = "fakulte_Ad")
    private String fakulteAd;

    public Fakulte(String fakulteAd)
    {
        this.fakulteAd = fakulteAd;
    }

}
