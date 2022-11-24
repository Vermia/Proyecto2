package com.proyecto2.spring.controller.error;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import com.proyecto2.spring.controller.VideojuegoController;

@Component
public class CustomErrorAttributes extends DefaultErrorAttributes{
	
	private static final Logger logger = LoggerFactory.getLogger(VideojuegoController.class);

	private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	/**
	 * @author Pablo
	 * Metodo que devuelve los errores de los atributos
	 */
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
		logger.info("------ getErrorAttributes(): " + options);
		Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
		logger.info("------ getErrorAttributes(): " + options);		

		Object timestamp = errorAttributes.get("timestamp");
		if (timestamp == null) {
			errorAttributes.put("timestamp", dateFormat.format(new Date()));
		} else {
			errorAttributes.put("timestamp", dateFormat.format((Date) timestamp));
		}

		errorAttributes.remove("trace");

		errorAttributes.put("jdk", System.getProperty("java.version"));
		
		errorAttributes.put("infoadicional", "videojuego no desarrollado");		

		return errorAttributes;
	}

}
