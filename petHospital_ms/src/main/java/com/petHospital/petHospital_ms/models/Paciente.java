package com.petHospital.petHospital_ms.models;

import org.springframework.data.annotation.Id;
import java.util.Date;

public class Paciente {
    @Id
    private String nombre;
    private String tipo;
    private Integer edad;
    private Date fechaIngreso;
    private String estado;

    public Paciente(String nombre, String tipo, Integer edad, Date fechaIngreso, String estado) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.edad = edad;
        this.fechaIngreso = fechaIngreso;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
