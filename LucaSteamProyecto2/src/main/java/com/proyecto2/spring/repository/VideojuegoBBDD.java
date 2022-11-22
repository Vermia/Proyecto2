package com.proyecto2.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyecto2.spring.model.Videojuego;



@Repository
public interface VideojuegoBBDD extends JpaRepository<Videojuego, Integer>{
	public List<Videojuego> findByNombre(String nombre);
		
	public Videojuego save(Videojuego juego);
}
