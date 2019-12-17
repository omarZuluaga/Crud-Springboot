package com.example.demo.shared.infrastructure.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface MapperApiRest <I, O>{
	public I dtoToDominio(O o);
	public O dominioToDto(I i);
	public default List<O> listDominioToDto(List<I> instancias){
		return instancias.stream().map(this::dominioToDto).collect(Collectors.toList());
	}
	public default List<I> listDtoToDominio(List<O> instancias){
		return instancias.stream().map(this::dtoToDominio).collect(Collectors.toList());
	}
}
