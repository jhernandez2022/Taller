package com.jonathanhernandez.tienda.repository;

import com.jonathanhernandez.tienda.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
