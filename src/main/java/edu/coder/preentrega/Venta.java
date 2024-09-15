package edu.coder.preentrega;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "VENTA")

public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ID_CLIENTE")
    private long id_cliente;

    @Column(name = "MONTO")
    private double monto;

    @Column(name = "FECHA")
    private Date fecha; //ejemplo "2024-09-14"

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idcliente", referencedColumnName="id")
    private Cliente cliente;

    public Venta() {
    }

    public Venta(double monto, Date fecha, Cliente cliente) {
        this.cliente = cliente;
        this.monto = monto;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(long id_cliente) {
        this.id_cliente = id_cliente;
    }


    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venta venta = (Venta) o;
        return id == venta.id && id_cliente == venta.id_cliente && Double.compare(monto, venta.monto) == 0 && Objects.equals(fecha, venta.fecha) && Objects.equals(cliente, venta.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id_cliente, monto, fecha, cliente);
    }

    @Override
    public String toString() {
        return "Venta{" +
                "id=" + id +
                ", id_cliente=" + id_cliente +
                ", monto=" + monto +
                ", fecha=" + fecha +
                '}';
    }
}