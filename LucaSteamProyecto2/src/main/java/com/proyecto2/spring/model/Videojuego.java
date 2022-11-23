package com.proyecto2.spring.model;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="videojuegos")
public class Videojuego {
	// Atributos:
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	public Videojuego() {}

	public Videojuego(int id, String nombre, int lanzamiento, String editora, String plataforma, String genero,
			double ventasAmerica, double ventasEuropa, double ventasJapon, double ventasOtros) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.lanzamiento = lanzamiento;
		this.editora = editora;
		this.plataforma = plataforma;
		this.genero = genero;
		this.ventasamerica = ventasAmerica;
		this.ventaseuropa = ventasEuropa;
		this.ventasjapon = ventasJapon;
		this.ventasotros = ventasOtros;
		this.ventasglobal = calcularGlobal(ventasAmerica, ventasEuropa, ventasJapon, ventasOtros);
	}
	
	// Getters y Setters:
	@Column(name="id")
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	public int getLanzamiento() { return lanzamiento; }
	public void setLanzamiento(int lanzamiento) { this.lanzamiento = lanzamiento; }

	public String getEditora() { return editora; }
	public void setEditora(String editora) { this.editora = editora; }

	public String getPlataforma() { return plataforma; }
	public void setPlataforma(String plataforma) { this.plataforma = plataforma; }

	public String getGenero() { return genero; }
	public void setGenero(String genero) { this.genero = genero; }

	public double getVentasAmerica() { return ventasamerica; }
	public void setVentasAmerica(double ventasAmerica) { this.ventasamerica = ventasAmerica; }

	public double getVentasEuropa() { return ventaseuropa; }
	public void setVentasEuropa(double ventasEuropa) { this.ventaseuropa = ventasEuropa; }

	public double getVentasJapon() { return ventasjapon; }
	public void setVentasJapon(double ventasJapon) { this.ventasjapon = ventasJapon; }

	public double getVentasOtros() { return ventasotros; }
	public void setVentasOtros(double ventasOtros) { this.ventasotros = ventasOtros; }

	public double getVentasGlobal() { return ventasglobal; }
	public void setVentasGlobal(double ventasGlobal) { this.ventasglobal = ventasGlobal; }
	
	// toString:
	@Override
	public String toString() {
		return "Videojuego [id=" + id + ", nombre=" + nombre + ", lanzamiento=" + lanzamiento + ", editora=" + editora
				+ ", plataforma=" + plataforma + ", genero=" + genero + ", ventasAmerica=" + ventasamerica
				+ ", ventasEuropa=" + ventaseuropa + ", ventasJapon=" + ventasjapon + ", ventasOtros=" + ventasotros
				+ ", ventasGlobal=" + ventasglobal + "]";
	}

	// hashCode:
	@Override
	public int hashCode() {
		return Objects.hash(editora, lanzamiento, genero, id, nombre, plataforma, ventasamerica, ventaseuropa, ventasglobal,
				ventasjapon, ventasotros);
	}

	// Equals:
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		
		Videojuego other = (Videojuego) obj;
		return Objects.equals(editora, other.editora) && Objects.equals(lanzamiento, other.lanzamiento)
				&& Objects.equals(genero, other.genero) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(plataforma, other.plataforma)
				&& Double.doubleToLongBits(ventasamerica) == Double.doubleToLongBits(other.ventasamerica)
				&& Double.doubleToLongBits(ventaseuropa) == Double.doubleToLongBits(other.ventaseuropa)
				&& Double.doubleToLongBits(ventasglobal) == Double.doubleToLongBits(other.ventasglobal)
				&& Double.doubleToLongBits(ventasjapon) == Double.doubleToLongBits(other.ventasjapon)
				&& Double.doubleToLongBits(ventasotros) == Double.doubleToLongBits(other.ventasotros);
	}

	// Calcular las ventas globales:
	public double calcularGlobal(double ventasAmerica, double ventasEuropa, double ventasJapon, double ventasOtros) {
		double res = ventasAmerica + ventasEuropa + ventasJapon + ventasOtros;
		return res;
	}
	
}
