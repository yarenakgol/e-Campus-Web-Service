package com.example.backend;

import com.example.backend.dto.InsanKaynaklariCreateDTO;
import com.example.backend.dto.YoneticiCreateDTO;
import com.example.backend.service.InsanKaynaklariService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.example.backend.dto.UserCreateDTO;
import com.example.backend.service.UserService;
import com.example.backend.service.YoneticiService;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	CommandLineRunner createInitialUsers(UserService userService) {
		return (args) -> {
/*
			UserCreateDTO user = new UserCreateDTO();
			user.setUserName("User1");
			user.setFirstName("Yaren");
			user.setLastName("Akgol");
			user.setEMail("yarenakgol@ogr.bandirma.edu.tr");
			user.setOgrNo("191502023");
			user.setPhoneNum("05538938573");

			userService.createUser(user);

			UserCreateDTO user2 = new UserCreateDTO();
			user2.setUserName("User2");
			user2.setFirstName("Serhat");
			user2.setLastName("Toktas");
			user2.setEMail("serhattoktas@ogr.bandirma.edu.tr");
			user2.setOgrNo("191502027");
			user2.setPhoneNum("05511778576");
			userService.createUser(user2);
*/
		};
	}
	Date test=new Date(1000L);
		@Bean
		CommandLineRunner createInitialInsanKaynaklari(InsanKaynaklariService insanKaynaklariService) {
			return (args) -> {
		InsanKaynaklariCreateDTO iknew= new InsanKaynaklariCreateDTO();
		/*
		iknew.setInsanKaynaklariAd("Kadir");
		iknew.setInsanKaynaklariSoyad("Karataş");
		iknew.setInsanKaynaklariEmail("insankaynagi1@bandirma.edu.tr");
		iknew.setInsanKaynaklariTelNo(634646L);

		iknew.setInsanKaynaklariGirisTarihi(test);
		iknew.setInsanKaynaklariDogumGun(test);
		iknew.setInsanKaynaklariKimlikNo(4567891L);
		insanKaynaklariService.createInsanKaynaklari(iknew);*/
			};
		}
	@Bean
	CommandLineRunner createInitialYonetici(YoneticiService YoneticiService) {
		return (args) -> {
		/*	YoneticiCreateDTO yonetnew= new YoneticiCreateDTO();
			yonetnew.setFakulteID(1L);
			yonetnew.setEnstituId(1L);
			yonetnew.setBolumID(1L);
			yonetnew.setPersonelID(1L);
			yonetnew.setYoneticiAd("Xmail");
			yonetnew.setYoneticiSoyad("soyad");
			yonetnew.setYoneticiEmail("xx.2@gfgg.com");
			yonetnew.setYoneticiTelNo(5437761L);

			yonetnew.setYoneticiGirisTarihi(test);
			yonetnew.setYoneticiDogumGun(test);
			YoneticiService.createYonetici(yonetnew);

		 */
};
	}



}
