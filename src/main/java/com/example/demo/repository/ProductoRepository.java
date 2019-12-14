package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.ProductoDto;

public interface ProductoRepository extends JpaRepository<ProductoDto, String> {

}
