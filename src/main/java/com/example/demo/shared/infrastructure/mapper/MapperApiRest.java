package com.example.demo.shared.infrastructure.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface MapperApiRest <I, O>{
	public I apiRecibir(O o);
	public O apiConvertir(I i);
	public default List<O> apiConvertir(List<I> instancias){
		return instancias.stream().map(this::apiConvertir).collect(Collectors.toList());
	}
	public default List<I> apiRecibir(List<O> instancias){
		return instancias.stream().map(this::apiRecibir).collect(Collectors.toList());
	}
}
