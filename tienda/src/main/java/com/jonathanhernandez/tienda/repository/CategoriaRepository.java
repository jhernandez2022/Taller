package com.jonathanhernandez.tienda.repository;

import com.jonathanhernandez.tienda.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}