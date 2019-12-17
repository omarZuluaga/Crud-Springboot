package com.example.demo.shared.infrastructure.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface MapperRest <A, B> {
	public A restToDominio(B b);
	public B dominioToRest(A a);
	public default List<B> listDominioToListRest(List<A> instancias){
		return instancias.stream().map(this::dominioToRest).collect(Collectors.toList());
	}
	public default List<A> listRestToListDominio(List<B> instancias){
		return instancias.stream().map(this::restToDominio).collect(Collectors.toList());
	}
}
