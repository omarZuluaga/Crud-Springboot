package com.example.demo.infraestructura.repository.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.infraestructura.dto.ProductoDto;

public interface ProductoRepository extends JpaRepository<ProductoDto, String> {

}
