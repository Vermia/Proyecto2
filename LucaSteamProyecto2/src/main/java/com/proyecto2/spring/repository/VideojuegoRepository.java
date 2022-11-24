package com.proyecto2.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto2.spring.model.Videojuego;

public interface VideojuegoRepository {
	
	
	public List<Videojuego> cargaJuegos();
	
	public List<Videojuego>findByGenero(String genero);
	
	public List<Videojuego> findBySigloXX();
	
	public List<Videojuego> findByAniosPares();
	
	public void deleteById(int id);
	
	//public Videojuego save();
}
