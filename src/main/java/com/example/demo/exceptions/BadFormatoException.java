package com.example.demo.exceptions;

public class BadFormatoException extends RuntimeException{
	public BadFormatoException() {
		super("Formato no permitido, solo mayusculas");
	}
}
