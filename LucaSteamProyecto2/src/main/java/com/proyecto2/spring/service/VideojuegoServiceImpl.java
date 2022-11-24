package com.proyecto2.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.proyecto2.spring.model.Videojuego;
import com.proyecto2.spring.repository.VideojuegoBBDD;
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
	@Autowired
	private VideojuegoBBDD videojuegoBBDD;
	
	
	/**
	 * Este método se encarga de cargar los juegos 
	 * de la capa datos
	 */
	@Override
	public List<Videojuego> cargaJuegos() {
		return videoJuegoRepository.cargaJuegos();
	}
	/**
	 * @author Martin
	 * Guarda un nuevo Videojuego en la BD
	 */
	
	@Override
	public Videojuego save(Videojuego juego) {
		return videojuegoBBDD.save(juego);
		
	}
	
	/**
	 * @author Martin
	 * Lista todos los Videojuegos de la BD
	 */
	@Override
	public List<Videojuego> findAll(){
		return videojuegoBBDD.findAll();
	}
	
	@Override
	/**
	 * @author Pedro
	 * Muestra un Videojuego especifico (si existe) de la Base de Datos
	 */
	public Optional<Videojuego> findById(int id){
		return videojuegoBBDD.findById(id);
	}
	

	/**
	 * @author Martin
	 * Borra un videojuego de la BD
	 */
	@Override
	public Videojuego deleteById(int id) {
		Optional<Videojuego> j = videojuegoBBDD.findById(id);
		videojuegoBBDD.deleteById(id);
		return j.get();
	}

	//@Override
	/**
	 * @author Pablo
	 * Muestra un Videojuego del genero que desee el usuario
	 */
	
	public List<Videojuego> findByGenero(String genero) {
		return videoJuegoRepository.findByGenero(genero);
	}
	 
	
	/**
	 * @author Pablo
	 * Muestra los videojuegos publicados entre 1990 y 1999
	 */
	
	@Override
	public List<Videojuego> findBySigloXX() {
		return videojuegoBBDD.findBySigloXX();
	}
	
	/**
	 * @autor Alvaro
	 * Muestra los videojuegos de años pares
	 */
	@Override
	public List<Videojuego> findByAniosPares() {
		return videojuegoBBDD.findByAniosPares();
	}
	 



}
