package com.proyecto2.spring.controller.error;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Ioan
 */

/**
 * 
 * Clase que muestra los errores JSON
 *
 */


public class CustomErrorJson {
	
	private String timestamp;
	private int estado;
	private String error;
	private String traza;
	private List<String> mensaje;
	private String ruta;
	
	private String jdk;
	private String info_adicional;	

	public CustomErrorJson() {
		super();
		this.timestamp = "";
		this.estado = 0;
		this.error = "";
		this.traza = "";
		this.mensaje = new ArrayList<>();
		this.ruta = "";
		this.jdk = "No hay";
	}

	public CustomErrorJson(Date timestamp, int estado, String error, String traza, List<String> mensaje, String ruta,
			String jdk) {
		super();
		// Formato DD/MM/YY
		this.timestamp = this.cambiarTimeStamp(timestamp);
		this.estado = estado;
		this.error = error;
		this.traza = traza;
		this.mensaje = mensaje;
		this.ruta = ruta;
		this.jdk = jdk;
	}


	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public void setTimestamp(Date timestamp) {
		this.timestamp = this.cambiarTimeStamp(timestamp);
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getTraza() {
		return traza;
	}

	public void setTraza(String traza) {
		this.traza = traza;
	}

	public List<String> getMensaje() {
		return mensaje;
	}

	public void setMensaje(List<String> mensaje) {
		this.mensaje = mensaje;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getJdk() {
		return jdk;
	}

	public void setJdk(String jdk) {
		this.jdk = jdk;
	}

	public String getInfo_adicional() {
		return info_adicional;
	}

	public void setInfo_adicional(String info_adicional) {
		this.info_adicional = info_adicional;
	}
	
	
	

	@Override
	public String toString() {
		return "CustomErrorJson [timestamp=" + timestamp + ", estado=" + estado + ", error=" + error + ", traza="
				+ traza + ", mensaje=" + mensaje + ", ruta=" + ruta + ", jdk=" + jdk + ", info_adicional="
				+ info_adicional + "]";
	}
	
	/**
	 * 
	 * @author Ioan
	 * @param fecha
	 * @return
	 * Metodo que cambia el formato de la fecha.
	 */

	@SuppressWarnings("unused")
	private String cambiarTimeStamp(Date fecha) {
		
		final DateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		final DateFormat formatoDeFecha2 = new SimpleDateFormat("yyyy/MM/dd/ HH:mm:ss");
		return formatoDeFecha.format(fecha);
	}

}
