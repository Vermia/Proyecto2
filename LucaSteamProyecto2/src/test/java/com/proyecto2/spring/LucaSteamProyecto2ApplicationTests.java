package com.proyecto2.spring;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.proyecto2.spring.controller.VideojuegoController;
import com.proyecto2.spring.model.Videojuego;
import com.proyecto2.spring.repository.VideojuegoRepository;
import org.springframework.boot.test.web.client.TestRestTemplate;

/**
 * 
 * @author Martin y Ioan
 *
 */
@SpringBootTest
class LucaSteamProyecto2ApplicationTests {
	@Autowired
	VideojuegoController controller;
	@Autowired
	TestRestTemplate restTempl;
	@Autowired
	VideojuegoRepository vidRep;

	/**
	 * Test que omprueba que el archivo csv exista
	 */
	
	@Test
	void testListaFicheroNoVacia() {
		ArrayList<Videojuego> lista = (ArrayList<Videojuego>) vidRep.cargaJuegos();

		assertThat(lista).isNotEmpty();
	}

	/**
	 * Comprobar si la carga de juegos es igual a
	 *  la cantidad de lineas de csv que equivale a 16598.
	 */
	// 
	@Test
	void testIgualLineasCsv() {
		ArrayList<Videojuego> lista = (ArrayList<Videojuego>) vidRep.cargaJuegos();

		assertThat(lista.size()).isEqualTo(16598);
	}
	
	@Test
	void testListaCreadaNoVacia() {
		Videojuego j1 = new Videojuego(1, "a" );
		Videojuego j2 = new Videojuego(2, "b" );

		controller.altaJuegos(j1);
		controller.altaJuegos(j2);
		
		ResponseEntity<Collection<Videojuego>> res = controller.listarJuegos();
		assertThat(res.getBody()).isNotEmpty();
	}
	
	@Test
	void testJuegoNoNull() {
		
	}
	
	
}
