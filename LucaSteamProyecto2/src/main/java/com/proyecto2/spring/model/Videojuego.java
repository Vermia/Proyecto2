package com.proyecto2.spring.model;

import java.time.LocalDate;
import java.util.Objects;

public class Videojuego {
	// Atributos:
	private Long id;
	private String nombre;
	private LocalDate fecha;
	private String editora;
	private String plataforma;
	private String genero;
	private double ventasAmerica;
	private double ventasEuropa;
	private double ventasJapon;
	private double ventasOtros;
	private double ventasGlobal;
	
	// Constructores;
	public Videojuego() {}

	public Videojuego(Long id, String nombre, LocalDate fecha, String editora, String plataforma, String genero,
			double ventasAmerica, double ventasEuropa, double ventasJapon, double ventasOtros) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.editora = editora;
		this.plataforma = plataforma;
		this.genero = genero;
		this.ventasAmerica = ventasAmerica;
		this.ventasEuropa = ventasEuropa;
		this.ventasJapon = ventasJapon;
		this.ventasOtros = ventasOtros;
		this.ventasGlobal = calcularGlobal(ventasAmerica, ventasEuropa, ventasJapon, ventasOtros);
	}
	
	// Getters y Setters:
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	public LocalDate getFecha() { return fecha; }
	public void setFecha(LocalDate fecha) { this.fecha = fecha; }

	public String getEditora() { return editora; }
	public void setEditora(String editora) { this.editora = editora; }

	public String getPlataforma() { return plataforma; }
	public void setPlataforma(String plataforma) { this.plataforma = plataforma; }

	public String getGenero() { return genero; }
	public void setGenero(String genero) { this.genero = genero; }

	public double getVentasAmerica() { return ventasAmerica; }
	public void setVentasAmerica(double ventasAmerica) { this.ventasAmerica = ventasAmerica; }

	public double getVentasEuropa() { return ventasEuropa; }
	public void setVentasEuropa(double ventasEuropa) { this.ventasEuropa = ventasEuropa; }

	public double getVentasJapon() { return ventasJapon; }
	public void setVentasJapon(double ventasJapon) { this.ventasJapon = ventasJapon; }

	public double getVentasOtros() { return ventasOtros; }
	public void setVentasOtros(double ventasOtros) { this.ventasOtros = ventasOtros; }

	public double getVentasGlobal() { return ventasGlobal; }
	public void setVentasGlobal(double ventasGlobal) { this.ventasGlobal = ventasGlobal; }
	
	// toString:
	@Override
	public String toString() {
		return "Videojuego [id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", editora=" + editora
				+ ", plataforma=" + plataforma + ", genero=" + genero + ", ventasAmerica=" + ventasAmerica
				+ ", ventasEuropa=" + ventasEuropa + ", ventasJapon=" + ventasJapon + ", ventasOtros=" + ventasOtros
				+ ", ventasGlobal=" + ventasGlobal + "]";
	}

	// hashCode:
	@Override
	public int hashCode() {
		return Objects.hash(editora, fecha, genero, id, nombre, plataforma, ventasAmerica, ventasEuropa, ventasGlobal,
				ventasJapon, ventasOtros);
	}

	// Equals:
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		
		Videojuego other = (Videojuego) obj;
		return Objects.equals(editora, other.editora) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(genero, other.genero) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(plataforma, other.plataforma)
				&& Double.doubleToLongBits(ventasAmerica) == Double.doubleToLongBits(other.ventasAmerica)
				&& Double.doubleToLongBits(ventasEuropa) == Double.doubleToLongBits(other.ventasEuropa)
				&& Double.doubleToLongBits(ventasGlobal) == Double.doubleToLongBits(other.ventasGlobal)
				&& Double.doubleToLongBits(ventasJapon) == Double.doubleToLongBits(other.ventasJapon)
				&& Double.doubleToLongBits(ventasOtros) == Double.doubleToLongBits(other.ventasOtros);
	}

	// Calcular las ventas globales:
	public double calcularGlobal(double ventasAmerica, double ventasEuropa, double ventasJapon, double ventasOtros) {
		double res = ventasAmerica + ventasEuropa + ventasJapon + ventasOtros;
		return res;
	}
	
}
