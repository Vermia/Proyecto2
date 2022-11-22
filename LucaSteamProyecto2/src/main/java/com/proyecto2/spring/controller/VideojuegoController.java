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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
/**
 * 
 * @author Ioan
 *
 */


/**
 * 
 * Clase VideojuegoController que se encarga 
 * de acceder a los metodos REST
 *
 */
@RestController
@RequestMapping("/videojuego")
@Tag(name = "movil", description = "Movil API")
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
	
	@Operation(summary = "Dar de alta un juego", description = "A partir del cuerpo de la request, agregar un nuevo juego a la base de datos", tags = 
		{"videojuego" })
	@ApiResponses(value = {
		@ApiResponse(responseCode = "201", description = "Juego creado", content = {
				@Content(mediaType = "application/json", schema = @Schema(implementation = Videojuego.class)) }),
		@ApiResponse(responseCode = "400", description = "No válido (NO implementado) ", content = @Content)})
	@PostMapping
	public void altaJuegos(@RequestBody Videojuego juego) {
		service.save(juego);
	}
	
	/**
	 * 
	 * @return Método que se encarga de listar los juegos
	 * de la BBDD.
	 */
	
	@Operation(summary = "Listar todos los juegos", description = "Crea y muestra una lista con todos los videojuegos almacenados", tags = 
		{"videojuego" })
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Juegos mostrados", content = {
				@Content(mediaType = "application/json", schema = @Schema(implementation = Videojuego.class)) }),
		@ApiResponse(responseCode = "400", description = "No válido (NO implementado) ", content = @Content)})
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
