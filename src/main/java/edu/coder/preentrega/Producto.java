package edu.coder.preentrega;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PRODUCTO")

public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NOMBRE_PRODUCTO")
    private String nombre_producto;

    @Column(name = "PRECIO")
    private double precio;

    @Column(name = "STOCK")
    private long stock;

    @ManyToMany(mappedBy = "Producto", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Venta_producto> venta_producto;

    public Producto() {
    }

    public Producto(String nombre_producto, double precio, long stock) {
        this.nombre_producto = nombre_producto;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public List<Venta_producto> getVenta_producto() {
        return venta_producto;
    }

    public void setVenta_producto(List<Venta_producto> venta_producto) {
        this.venta_producto = venta_producto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return id == producto.id && Double.compare(precio, producto.precio) == 0 && stock == producto.stock && Objects.equals(nombre_producto, producto.nombre_producto) && Objects.equals(venta_producto, producto.venta_producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre_producto, precio, stock, venta_producto);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre_producto='" + nombre_producto + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }

}
