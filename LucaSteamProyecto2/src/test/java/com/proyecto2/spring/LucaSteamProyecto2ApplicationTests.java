package com.proyecto2.spring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyecto2.spring.model.Videojuego;
import com.proyecto2.spring.repository.VideojuegoRepository;

@SpringBootTest
class LucaSteamProyecto2ApplicationTests {
	@Autowired
	VideojuegoRepository vidRep;

	@Test
	void testListaNoVacia() {
		ArrayList<Videojuego> lista = (ArrayList<Videojuego>) vidRep.cargaJuegos();
		
		assertThat(lista).isNotEmpty();
	}

}
