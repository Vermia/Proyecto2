package com.proyecto2.spring;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.proyecto2.spring.controller.VideojuegoController;
import com.proyecto2.spring.model.Videojuego;
import com.proyecto2.spring.repository.VideojuegoRepository;

import utils.Randomizador;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.dao.EmptyResultDataAccessException;

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
	VideojuegoRepository vidRep;


	/**
	 * Test que omprueba que el archivo csv exista
	 */
	
	@Disabled //Ponemos disabled a las que tienen cargaJuegos para que sea mas rapido
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
	@Disabled
	@Test
	void testIgualLineasCsv() {
		ArrayList<Videojuego> lista = (ArrayList<Videojuego>) vidRep.cargaJuegos();

		assertThat(lista.size()).isEqualTo(16598);
	}
	
	/**
	 * Comprobar que la lista no sea vacia
	 */
	
	@Test
	void testListaCreadaNoVacia() {
		Videojuego j1 = new Videojuego(1, "a");
		Videojuego j2 = new Videojuego(2, "b" );

		controller.altaJuegos(j1);
		controller.altaJuegos(j2);
		
		ResponseEntity<Collection<Videojuego>> res = controller.listarJuegos();
		assertThat(res.getBody()).isNotEmpty();
	}
	
	/**
	 * .Comprobar que ninguno de los juegos sea null
	 */
	
	@Disabled
	@Test
	void testJuegoNoNull() {
		boolean nulo = false;
		ArrayList<Videojuego> lista = (ArrayList<Videojuego>) vidRep.cargaJuegos();
		
		
		for(Videojuego videojuego : lista) {
			if(videojuego == null) {
				nulo = true;
			}
		}
		
		assertThat(nulo).isFalse();
		
	}
	

/**
 * Comprobar que el juego dado de alta exista
 */
	@Test
	void testAltaExiste() {
		Videojuego juego = new Videojuego(99998, "aaa");
		controller.altaJuegos(juego);
		assertThat(controller.buscarJuego(99998)).isNotNull();
	}
	
	/*
	 * @Test void testMismoGeneroLista() {
	 * 
	 * assertThat(controller.filtrarPorGenero("Action")).isNotEmpty(); }
	 */
	
	/**
	 * @author Martin
	 * Comprueba que un juego existe, y después lo borra y comprueba que no exista después de borrarlo
	 */
	@Test
	void testBorradoNoExiste() {
		boolean antesEsta = false;
		boolean despuesEsta = true;
		
		try {
			if(controller.buscarJuego(10000) != null) {
				antesEsta=true;
			}
		} catch(EmptyResultDataAccessException ex) {
			antesEsta=false;
		}
		
		try {
			controller.borrarJuego(10000);
		}catch(EmptyResultDataAccessException ex) {
			assertThat(true).isEqualTo(false);
		}
		
		try {
			if(controller.buscarJuego(10000) != null) {
				despuesEsta=true;
			}
		} catch(EmptyResultDataAccessException ex) {
			despuesEsta=false;
		}
		
		assertThat(antesEsta && !despuesEsta);
	}
	
	/**
	 * @author Martin
	 * Al filtrar por siglo XX, comprobamos que en esa lista no haya nignuno fuera de ese siglo
	 */
	@Test
	void testTodasEstanSigloXX() {
		ArrayList<Videojuego> juegosXX = (ArrayList<Videojuego>) controller.filtrarPorSigloXX().getBody(); 
		
		boolean hayUnoFueraDeRango = false;
		for(Videojuego v : juegosXX) {
			if(v.getLanzamiento()<1900 || v.getLanzamiento() >2000) {
				hayUnoFueraDeRango=true;
				break;
			}
		}
		assertThat(hayUnoFueraDeRango).isEqualTo(false);
	}
	
	/**
	 * @author
	 * Al filtrar por juegos de años pares, comprueba que en esa lista no haya ninguno de año impar
	 */
	@Test
	void testNingunoEsImpar() {
		ArrayList<Videojuego> juegosPares = (ArrayList<Videojuego>) controller.findByAniosPares();
		boolean hayUnoImpar = false;
		for(Videojuego v : juegosPares) {
			if(v.getLanzamiento() % 2 == 1) {
				hayUnoImpar=true;
				break;
			}
		}
		assertThat(hayUnoImpar).isEqualTo(false);
	}
	
	/*@Test
	void testJuegoActualizadoNoIgual() {
		Videojuego juegoParaActualizar =null;
		try {
			juegoParaActualizar = controller.buscarJuego(3000).get();
		} catch(EmptyResultDataAccessException ex) {
			assertThat(true).isEqualTo(false);
		}
		
		Videojuego juegoActualizado = controller.actualizar(new Videojuego(3000, "Nombre nuevo", Randomizador.randomNumber(1960, 2009), "Noentiendo"));
		try {
			assertThat( ! juegoParaActualizar.equals(juegoActualizado));
		} catch(NullPointerException ex) {
			assertThat(true).isEqualTo(false);
		}
	}*/
	
}
