package com.jonathanhernandez.tienda.repository;

import com.jonathanhernandez.tienda.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
