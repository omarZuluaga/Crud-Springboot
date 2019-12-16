package com.example.demo.shared.infrastructure.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface MapperRest <A, B> {
	public A recibir(B b);
	public B convertir(A a);
	public default List<B> convertir(List<A> instancias){
		return instancias.stream().map(this::convertir).collect(Collectors.toList());
	}
	public default List<A> recibir(List<B> instancias){
		return instancias.stream().map(this::recibir).collect(Collectors.toList());
	}
}
