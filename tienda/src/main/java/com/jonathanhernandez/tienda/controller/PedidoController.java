package com.jonathanhernandez.tienda.controller;

import com.jonathanhernandez.tienda.entity.Pedido;
import com.jonathanhernandez.tienda.service.PedidoService;
import com.jonathanhernandez.tienda.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/pedido")
public class PedidoController {

    private final PedidoService pedidoService;
    private final UsuarioService usuarioService;

    public PedidoController(PedidoService pedidoService, UsuarioService usuarioService) {
        this.pedidoService = pedidoService;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("pedidos", pedidoService.listar());
        return "pedido";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("pedido", new Pedido());
        model.addAttribute("usuarios", usuarioService.listar());
        model.addAttribute("modoEdicion", false);
        return "pedido-form";
    }

    @PostMapping("/guardar")
    public String crear(@Valid @ModelAttribute("pedido") Pedido pedido,
                        BindingResult result,
                        Model model) {

        if (result.hasErrors()) {
            model.addAttribute("usuarios", usuarioService.listar());
            model.addAttribute("modoEdicion", false);
            return "pedido-form";
        }

        pedidoService.crear(pedido);
        return "redirect:/api/pedido";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("pedido", pedidoService.buscarPorId(id));
        model.addAttribute("usuarios", usuarioService.listar());
        model.addAttribute("modoEdicion", true);
        return "pedido-form";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Integer id,
                             @Valid @ModelAttribute("pedido") Pedido pedido,
                             BindingResult result,
                             Model model) {

        if (result.hasErrors()) {
            model.addAttribute("usuarios", usuarioService.listar());
            model.addAttribute("modoEdicion", true);
            return "pedido-form";
        }

        pedidoService.actualizar(id, pedido);
        return "redirect:/api/pedido";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        pedidoService.eliminar(id);
        return "redirect:/api/pedido";
    }
}