package com.proyecto2.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto2.spring.model.Videojuego;

@Repository
public interface VideojuegoBBDD extends JpaRepository<Videojuego, Integer>{
	
}
