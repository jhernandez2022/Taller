package com.jonathanhernandez.tienda.service;

import com.jonathanhernandez.tienda.entity.Categoria;
import java.util.List;

public interface CategoriaService {

    List<Categoria> listar();
    Categoria crear(Categoria categoria);
    Categoria actualizar(Integer id, Categoria categoria);
    Categoria buscarPorId(Integer id);
    void eliminar(Integer id);
}