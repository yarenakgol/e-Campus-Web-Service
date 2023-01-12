package com.example.backend.dto;

import com.example.backend.validator.model.Ders;
import lombok.Getter;

import java.io.Serializable;

@Getter
public final class DersViewDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	//private Long ogrenciid;
	//private Long bolumid;
	//private Long donemid;
	private Long id;
	private String name;
	private String donemadi;
	private Integer kredi;
	private Integer akts;

	private DersViewDTO(Long id,String name,String donemadi,Integer kredi,Integer akts) {
		//Long ogrenciid,Long bolumid,Long donemid,
		//this.ogrenciid = ogrenciid;
		//this.bolumid = bolumid;
		//this.donemid = donemid;
		this.id = id;
		this.name = name;
		this.donemadi = donemadi;
		this.kredi = kredi;
		this.akts=akts;
	}

	public static DersViewDTO of(Ders ders) {
		return new DersViewDTO(ders.getId(), ders.getName(),ders.getDonemadi(),ders.getKredi(),ders.getAkts());
		//ders.getOgrenciIsleri().getId(), ders.getBolum().getId(), ders.getDonem().getId(),
	}

}
