package com.proyecto2.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto2.spring.service.VideojuegoService;

@RestController
@RequestMapping("/videojuego")
public class VideojuegoController {
	
	@Autowired
	private VideojuegoService service;
	
	private static final Logger logger = LoggerFactory.getLogger(VideojuegoController.class);
	
	@GetMapping
	public List
}
