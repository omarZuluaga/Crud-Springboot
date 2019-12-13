package com.example.demo.exceptions;

public class ExtendetCodeException extends RuntimeException{
	public ExtendetCodeException() {
		super("Codigo excede longitud de 64 bits o es menor de 32 bits");
	}
}
