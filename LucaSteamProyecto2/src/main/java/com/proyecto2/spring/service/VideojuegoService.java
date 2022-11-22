package com.proyecto2.spring.service;

import java.util.List;
import java.util.Optional;

import com.proyecto2.spring.model.Videojuego;

public interface VideojuegoService {

	public List<Videojuego> cargaJuegos();
	
	public void save(Videojuego juego);
	public List<Videojuego> findAll();
	
	public Optional<Videojuego> findById(int id);
}
