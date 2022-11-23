package com.proyecto2.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


@Configuration
public class AppConfig {
	/**
	 * 
	 * @return Se encarga de poner la información especifica de la API
	 * 
	 */

	@Bean
	public OpenAPI VideojuegoOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("API Videojuegos")
				.description("Documentacion de la API videojuegos")		
				.version("v1.0")
				.contact(new Contact().name("Grupo2").
						url("https://grupo2@proyecto2.es").email("grupo2@proyecto2.es"))
				.license(new License().name("Licencia de Pago").url("http://springdoc.org")))
				.externalDocs(new ExternalDocumentation()
				.description("API de administracion de videojuegos para la plataforma LucaSteam")
				.url("https://proyecto2.es"));
						
	}
}
