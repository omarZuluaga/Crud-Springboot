package com.example.demo.infraestructura.repository.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.infraestructura.dto.ItemDto;

public interface ItemRepository extends JpaRepository<ItemDto, String>{

}
