package com.example.demo.shared.infrastructure.mapper;

public interface MapperApiRest <I, O>{
	public I recibir(O o);
	public O convertir(I i);
}
