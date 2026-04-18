package com.jonathanhernandez.tienda.service;

import com.jonathanhernandez.tienda.entity.Usuario;

import java.util.List;

public interface UsuarioService{
    List<Usuario> listar();
    Usuario crear(Usuario usuario);
    Usuario actualizar(Integer id, Usuario usuario);
    Usuario buscarPorId(Integer id);
    void eliminar(Integer id);
}
