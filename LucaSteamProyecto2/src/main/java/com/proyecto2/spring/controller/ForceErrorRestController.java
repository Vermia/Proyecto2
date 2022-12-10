package com.proyecto2.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForceErrorRestController {
	//Es un error normal y corriente. No mapeado
    @GetMapping(value = "/videojuegos/throwException")
    public void throwException() {
        throw new IllegalArgumentException("\"I am the error message from Rest Controller\"");
    }
}
