package com.proyecto2.spring.repository;

import java.util.List;

import com.proyecto2.spring.model.Videojuego;

public interface VideojuegoRepository {
	public List<Videojuego> cargaJuegos();
}
