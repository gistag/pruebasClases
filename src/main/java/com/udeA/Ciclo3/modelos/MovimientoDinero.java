package com.udeA.Ciclo3.modelos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
@Entity
@Table(name="Movimientos")
public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private long monto;
    private String concepto;
    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado usuario;

    public MovimientoDinero(long monto, String concepto, Empleado empleado) {
        this.monto = monto;
        this.concepto = concepto;
        this.usuario = empleado;
    }

    public MovimientoDinero() {

    }

    public Empleado getUsuario() {
        return usuario;
    }

    public void setUsuario(Empleado usuario) {
        this.usuario = usuario;
    }

    public MovimientoDinero(Empleado empleado) {
        this.usuario = empleado;
    }
}
