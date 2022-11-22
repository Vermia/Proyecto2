package com.proyecto2.spring.service;

import java.util.List;

import com.proyecto2.spring.model.Videojuego;

public interface VideojuegoService {

	public List<Videojuego> cargaJuegos();
	
	public void save(Videojuego juego);

}
