package edu.coder.preentrega;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "VENTA_PRODUCTO")

public class Venta_producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "CANTIDAD")
    private int cantidad;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="id_venta", referencedColumnName="id")
    private Venta venta;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="id_producto", referencedColumnName="id")
    private Producto Producto;

    public Venta_producto() {
    }

    public Venta_producto(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public edu.coder.preentrega.Producto getProducto() {
        return Producto;
    }

    public void setProducto(edu.coder.preentrega.Producto producto) {
        Producto = producto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venta_producto that = (Venta_producto) o;
        return id == that.id && cantidad == that.cantidad && Objects.equals(venta, that.venta) && Objects.equals(Producto, that.Producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cantidad, venta, Producto);
    }

    @Override
    public String toString() {
        return "Venta_producto{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                '}';
    }

}
