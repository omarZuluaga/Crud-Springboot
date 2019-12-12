package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Producto;

public interface ProductoRepository extends JpaRepository<Producto, String> {

}
