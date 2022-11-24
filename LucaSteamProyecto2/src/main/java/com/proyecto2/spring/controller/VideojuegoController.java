package com.proyecto2.spring.controller;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
 * Clase VideojuegoController que se encarga de acceder a los metodos REST
 *
 */
@RestController
@RequestMapping("/videojuego")
@Tag(name = "videojuego", description = "Juegos API")
public class VideojuegoController {
	@Autowired
	private VideojuegoService service;

	/**
	 * 
	 * @return Metodo que se encarga de cargar los juegos de un csv.
	 */

	@GetMapping
	public List<Videojuego> cargaJuegos() {
		List<Videojuego> listjuego = service.cargaJuegos();
		for (Videojuego videojuego : listjuego) {
			altaJuegos(videojuego);
		}
		return listjuego;

	}

	@PostMapping()
	public void altaJuegos(@RequestBody Videojuego juego) {
		service.save(juego);
	}

	/**
	 * 
	 * @return Método que se encarga de listar los juegos de la BBDD.
	 */

	@Operation(summary = "Listar todos los juegos", description = "Crea y muestra una lista con todos los videojuegos almacenados", tags = {
			"videojuego" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Juegos mostrados", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Videojuego.class)) }),
			@ApiResponse(responseCode = "400", description = "No válido (NO implementado) ", content = @Content) })
	@GetMapping("/listadovideojuegos")
	public ResponseEntity<Collection<Videojuego>> listarJuegos() {
		Collection<Videojuego> videojuegos = service.findAll();

		if (videojuegos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(videojuegos);
	}
	
	/**
	 * @author martin
	 * @return respuesta del servidor
	 * Este metodo devuelve los juegos 
	 */
	@Operation(summary = "Listar los juegos del siglo XX", description = "Crea y muestra una lista con todos los videojuegos del siglo XX", tags = {
		"videojuego" })
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Juegos mostrados", content = {
				@Content(mediaType = "application/json", schema = @Schema(implementation = Videojuego.class)) }),
		@ApiResponse(responseCode = "400", description = "No válido (NO implementado) ", content = @Content) })
	@GetMapping("/sigloxx")
	public ResponseEntity<Collection<Videojuego>> filtrarPorSigloXX(){
		Collection<Videojuego> videojuegos = service.findBySigloXX();

		if (videojuegos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(videojuegos);
	}
	/**
	 * 
	 * @param id
	 * @return Método que se encarga de buscar un juego por el id indicado en la
	 *         BBDD.
	 */

	@Operation(summary = "Listar un videojuego", description = "Busca un videojuego en la base de datos y lo muestra", tags = {
		"videojuego" })
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Juego mostrado", content = {
				@Content(mediaType = "application/json", schema = @Schema(implementation = Videojuego.class)) }),
		@ApiResponse(responseCode = "400", description = "No válido (NO implementado) ", content = @Content) ,
		@ApiResponse(responseCode = "404", description = "No encontrado ", content = @Content)})
		@GetMapping("/{id}")
	public Optional<Videojuego> buscarJuego(@PathVariable int id) {
		return service.findById(id);
	}
	
	/**
	 * @param genero
	 * @return Método que se encarga de buscar los videojuegos por el filtro
	 * deseado por el usuario
	 */
	
	@GetMapping("/genero/{genero}")
	public List<Videojuego> filtrarPorGenero(@PathVariable String genero) {
		return service.findByGenero(genero);
	}
	 
	
	/**
	 * @return Método que muestra los videojuegos de la plataforma por lanzamiento en año par
	 */
	@GetMapping("/fechapares")
	public List<Videojuego> findByAniosPares(){
		return service.findByAniosPares();
	}

	@Operation(summary = "Borrar un videojuego", description = "Busca un videojuego en la base de datos y lo elimina", tags = {
		"videojuego" })
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Juego eliminado", content = {
				@Content(mediaType = "application/json", schema = @Schema(implementation = Videojuego.class)) }),
		@ApiResponse(responseCode = "400", description = "No válido (NO implementado) ", content = @Content) ,
		@ApiResponse(responseCode = "404", description = "No encontrado ", content = @Content)})
	@DeleteMapping("/{id}")
	public ResponseEntity<Videojuego> borrarJuego(@PathVariable int id) {
		Videojuego videojuego = null;
		try {
			videojuego=service.deleteById(id);
		} catch(NoSuchElementException ex) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(videojuego);
	}
	
	@Operation(summary = "Actualizar un videojuego", description = "Actualiza un videojuego existente de la base de datos", tags = {
	"videojuego" })
	@ApiResponses(value = {
	@ApiResponse(responseCode = "200", description = "Juego actualizado", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = Videojuego.class)) }),
	@ApiResponse(responseCode = "400", description = "No válido (NO implementado) ", content = @Content) ,
	@ApiResponse(responseCode = "404", description = "No encontrado ", content = @Content)})
	@PutMapping

	public Videojuego actualizar(@RequestBody Videojuego videojuego) {
		return service.save(videojuego);
	}
}
