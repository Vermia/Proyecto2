package com.proyecto2.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.proyecto2.spring.controller.VideojuegoController;

@SpringBootApplication
public class LucaSteamProyecto2Application implements CommandLineRunner{

	@Autowired
	VideojuegoController videojuegoController;
	
	public static void main(String[] args) {
		SpringApplication.run(LucaSteamProyecto2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println("----------");
		videojuegoController.cargaJuegos();
	}

}
