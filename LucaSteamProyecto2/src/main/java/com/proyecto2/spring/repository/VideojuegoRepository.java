package com.proyecto2.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto2.spring.model.Videojuego;

public interface VideojuegoRepository extends JpaRepository<Videojuego, Integer>{
	
	
	public List<Videojuego> cargaJuegos();



}
