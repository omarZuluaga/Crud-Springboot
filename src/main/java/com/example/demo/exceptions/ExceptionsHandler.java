package com.example.demo.exceptions;


import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.dto.ErrorCode;

@RestControllerAdvice
public class ExceptionsHandler {
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorCode handlerException(Exception e) {
		ErrorCode ec = new ErrorCode();
		ec.setCodigo(this.Id());
		ec.setMensaje("error papá");
		logError(ec, e);
		return ec;
	}
	@ExceptionHandler(RegistroNoEncontradoException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorCode registroNoEncontrado(RegistroNoEncontradoException e) {
		ErrorCode ec = new ErrorCode();
		ec.setCodigo(this.Id());
		ec.setMensaje(e.getMessage());
		logError(ec, e);
		return ec;
	}
	
	@ExceptionHandler(ValorNoPermitidoException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorCode valorInferior(ValorNoPermitidoException e) {
		ErrorCode ec = new ErrorCode();
		ec.setCodigo(this.Id());
		ec.setMensaje(e.getMessage());
		logError(ec, e);
		return ec;
	}
	
	@ExceptionHandler(BadFormatoException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorCode badFormatoException(BadFormatoException e) {
		ErrorCode ec = new ErrorCode();
		ec.setCodigo(this.Id());
		ec.setMensaje(e.getMessage());
		logError(ec, e);
		return ec;
	}
	
	@ExceptionHandler(ExtendetCodeException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorCode extendetCodeException(ExtendetCodeException e) {
		ErrorCode ec = new ErrorCode();
		ec.setCodigo(this.Id());
		ec.setMensaje(e.getMessage());
		logError(ec, e);
		return ec;
	}
	private static final Logger LOG = Logger.getLogger(ExceptionHandler.class.getName());
	private void logError(ErrorCode ec, Exception e) {
		LOG.severe(ec.getCodigo());
		LOG.severe(ec.getMensaje());
		LOG.severe(e.getMessage());
	}
	
	public String Id() {
		return UUID.randomUUID().toString();
	}
	
}
