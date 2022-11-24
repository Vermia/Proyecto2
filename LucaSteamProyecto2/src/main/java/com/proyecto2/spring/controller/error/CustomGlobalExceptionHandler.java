package com.proyecto2.spring.controller.error;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Martin
 * Clase que se utiliza para canalizar las excepciones que salten, convirtiendolas en respuestas del servidor
 */

public class CustomGlobalExceptionHandler  extends ResponseEntityExceptionHandler{
	/*@ExceptionHandler(VideojuegoNotFoundException.class)
	public void springHandleNotFound(HttpServletResponse response) throws IOException {
		logger.info("------ StudentNotFoundException() ");
		response.sendError(HttpStatus.NOT_FOUND.value());
	}*/
	
	@ExceptionHandler(ConstraintViolationException.class)
	public void constraintViolationException(HttpServletResponse response) throws IOException {
		logger.info("------ ConstraintViolationException() ");
		response.sendError(HttpStatus.BAD_REQUEST.value());
	}
	
	/*@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
		HttpHeaders headers, HttpStatus status, WebRequest request) {

		logger.info("------ handleMethodArgumentNotValid()");
		
		CustomErrorJson customError = new CustomErrorJson();


		customError.setTimestamp(new Date());
		customError.setStatus(status.value());
		customError.setError(status.name());

		List<String> messages = new ArrayList<String>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			messages.add(error.getField() + ": " + error.getDefaultMessage());
		}
		customError.setMessage(messages);
		

		String uri = request.getDescription(false);
		uri = uri.substring(uri.lastIndexOf("=")+1);
		customError.setPath(uri);

		return new ResponseEntity<>(customError, headers, status);

	}*/
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
		HttpHeaders headers, HttpStatus status, WebRequest request) {
		logger.info("------ handleHttpRequestMethodNotSupported()");
		StringBuilder builder = new StringBuilder();
		builder.append(ex.getMethod());
		builder.append(" method is not supported for this request. Supported methods are ");
		ex.getSupportedHttpMethods().forEach(t -> builder.append(t + " "));

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
		body.put("status", status.value());
		body.put("error", ex.getLocalizedMessage());
		body.put("message", builder.toString());

		return new ResponseEntity<Object>(body, new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED);

	}
}
