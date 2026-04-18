package com.jonathanhernandez.tienda.controller;

import com.jonathanhernandez.tienda.entity.Producto;
import com.jonathanhernandez.tienda.service.ProductoService;
import com.jonathanhernandez.tienda.repository.CategoriaRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/producto")
public class ProductoController {

    private final ProductoService productoService;
    private final CategoriaRepository categoriaRepository;

    public ProductoController(ProductoService productoService,
                              CategoriaRepository categoriaRepository) {
        this.productoService = productoService;
        this.categoriaRepository = categoriaRepository;
    }

    // LISTA
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("productos", productoService.listar());
        return "producto";
    }

    // FORM NUEVO
    @GetMapping("/nuevo")
    public String nuevo(Model model){
        model.addAttribute("producto", new Producto());
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "producto-form";
    }

    // FORM EDITAR
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("producto", productoService.buscarPorId(id));
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "producto-form";
    }

    // GUARDAR
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Producto producto) {

        if (producto.getIdProducto() == null) {
            productoService.crear(producto);
        } else {
            productoService.actualizar(producto.getIdProducto(), producto);
        }

        return "redirect:/api/producto";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        productoService.eliminar(id);
        return "redirect:/api/producto";
    }
}