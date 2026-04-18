package com.jonathanhernandez.tienda.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_pedido")
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Integer idDetalle;

    @NotNull(message = "La cantidad no puede estar vacía")
    @Column(name = "cantidad")
    private Integer cantidadDetalle;

    @NotNull(message = "El precio no puede estar vacío")
    @Column(name = "precio_unitario")
    private BigDecimal precioDetalle;

    @NotNull(message = "Debe seleccionar un pedido")
    @Column(name = "id_pedido")
    private Integer idPedido;

    @NotNull(message = "Debe seleccionar un producto")
    @Column(name = "id_producto")
    private Integer idProducto;

    // Getters y Setters

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getCantidadDetalle() {
        return cantidadDetalle;
    }

    public void setCantidadDetalle(Integer cantidadDetalle) {
        this.cantidadDetalle = cantidadDetalle;
    }

    public BigDecimal getPrecioDetalle() {
        return precioDetalle;
    }

    public void setPrecioDetalle(BigDecimal precioDetalle) {
        this.precioDetalle = precioDetalle;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}