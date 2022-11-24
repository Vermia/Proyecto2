package com.proyecto2.spring.controller.error;

/**
 * 
 * @author Alvaro
 *
 */
public class VideojuegoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public VideojuegoNotFoundException() {
		super("No existe el videojuego");
	}

	public VideojuegoNotFoundException(int id) {
		super("No existe el videojuego: " + id);
	}
	
	public VideojuegoNotFoundException(String editora) {
		super("No existen juegos con la siguiente editora: " + editora);
	}
	
	
}
