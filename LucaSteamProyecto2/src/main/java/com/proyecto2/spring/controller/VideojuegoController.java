package com.proyecto2.spring.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto2.spring.model.Videojuego;
import com.proyecto2.spring.service.VideojuegoService;
/**
 * 
 * @author Ioan
 *
 */
@RestController
@RequestMapping("/videojuego")

/**
 * 
 * Clase VideojuegoController que se encarga 
 * de acceder a los metodos REST
 *
 */

public class VideojuegoController {
	
	@Autowired
	private VideojuegoService service;
	
	private static final Logger logger = LoggerFactory.getLogger(VideojuegoController.class);
	
	/**
	 * 
	 * @return Metodo que se encarga
	 * de cargar los juegos de un csv.
	 */
	
	
	@GetMapping
	public List<Videojuego>cargaJuegos(){
		return null;
		
	}
	
	/**
	 * 
	 * @return Método que se encarga de dar de alta
	 * los juegos y guardarlos en la BBDD
	 * 
	 * 
	 * */
	
	
	@PostMapping
	public void altaJuegos(@RequestBody Videojuego juego) {
		service.save(juego);
	}
	
	/**
	 * 
	 * @return Método que se encarga de listar los juegos
	 * de la BBDD.
	 * Nuevo comentario
	 */
	
	@GetMapping
	public List<Videojuego>listarJuegos(){
		return service.findAll();
		
	}
	
	/**
	 * 
	 * @param id
	 * @return Método que se encarga de buscar
	 * un juego por el id indicado en la BBDD.
	 */
	
	@GetMapping
	public Optional<Videojuego> buscarJuego(int id){
		return service.findById(id);
	}
	
	
}
