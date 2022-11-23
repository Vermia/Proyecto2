package com.proyecto2.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "videojuegos")
public class Videojuego {
	// Atributos:
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private int lanzamiento;
	private String editora;
	private String plataforma;
	private String genero;
	private double ventasamerica;
	private double ventaseuropa;
	private double ventasjapon;
	private double ventasotros;
	private double ventasglobal;
	// Constructores;
	public Videojuego() {
	}
	
	public Videojuego(int id, String nombre) {
		this.id=id; this.nombre=nombre;
	}

	public Videojuego(int id, String nombre, int lanzamiento, String editora, String plataforma, String genero,
			double ventasamerica, double ventaseuropa, double ventasjapon, double ventasotros) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.lanzamiento = lanzamiento;
		this.editora = editora;
		this.plataforma = plataforma;
		this.genero = genero;
		this.ventasamerica = ventasamerica;
		this.ventaseuropa = ventaseuropa;
		this.ventasjapon = ventasjapon;
		this.ventasotros = ventasotros;
		this.ventasglobal = calcularGlobal(ventasamerica, ventaseuropa, ventasjapon, ventasotros);

	}


	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getLanzamiento() {
		return lanzamiento;
	}

	public void setLanzamiento(int lanzamiento) {
		this.lanzamiento = lanzamiento;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public double getVentasamerica() {
		return ventasamerica;
	}

	public void setVentasamerica(double ventasamerica) {
		this.ventasamerica = ventasamerica;
	}

	public double getVentaseuropa() {
		return ventaseuropa;
	}

	public void setVentaseuropa(double ventaseuropa) {
		this.ventaseuropa = ventaseuropa;
	}

	public double getVentasjapon() {
		return ventasjapon;
	}

	public void setVentasjapon(double ventasjapon) {
		this.ventasjapon = ventasjapon;
	}

	public double getVentasotros() {
		return ventasotros;
	}

	public void setVentasotros(double ventasotros) {
		this.ventasotros = ventasotros;
	}

	public double getVentasglobal() {
		return ventasglobal;
	}

	public void setVentasglobal(double ventasglobal) {
		this.ventasglobal = ventasglobal;
	}

	// Calcular las ventas globales:
	public double calcularGlobal(double ventasAmerica, double ventasEuropa, double ventasJapon, double ventasOtros) {
		double res = ventasAmerica + ventasEuropa + ventasJapon + ventasOtros;
		return res;
	}

	@Override
	public String toString() {
		return "Videojuego [id=" + id + ", nombre=" + nombre + ", lanzamiento=" + lanzamiento + ", editora=" + editora
				+ ", plataforma=" + plataforma + ", genero=" + genero + ", ventasamerica=" + ventasamerica
				+ ", ventaseuropa=" + ventaseuropa + ", ventasjapon=" + ventasjapon + ", ventasotros=" + ventasotros
				+ ", ventasglobal=" + ventasglobal + "]";
	}

}
