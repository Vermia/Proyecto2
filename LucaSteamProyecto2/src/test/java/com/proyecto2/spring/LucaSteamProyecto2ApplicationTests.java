package com.proyecto2.spring;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyecto2.spring.model.Videojuego;
import com.proyecto2.spring.repository.VideojuegoRepository;


/**
 * 
 * @author Martin y Ioan
 *
 */
@SpringBootTest
class LucaSteamProyecto2ApplicationTests {
	@Autowired
	VideojuegoRepository vidRep;

	/**
	 * Test que omprueba que el archivo csv exista
	 */
	
	@Test
	void testListaNoVacia() {
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
	
	
}
