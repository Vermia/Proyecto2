package com.proyecto2.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto2.spring.model.Videojuego;
import com.proyecto2.spring.repository.VideojuegoRepository;
/**
 * 
 * @author Alvaro Blanco
 *
 */
@Service
public class VideojuegoServiceImpl implements VideojuegoService {
	@Autowired
	private VideojuegoRepository videoJuegoRepository;
	
	/**
	 * Este método se encarga de cargar los juegos 
	 * de la capa datos
	 */
	@Override
	public List<Videojuego> cargaJuegos() {
		return videoJuegoRepository.cargaJuegos();
	}

}
