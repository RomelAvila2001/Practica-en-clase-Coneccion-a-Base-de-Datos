/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.Date;

/**
 *
 * @author NANCY
 */
public class Asunto {
    private int codigo;
    private Date fechaInicio;
    private Date fechaFinalizacion;
    private String estado;
    private String cedulaClientefk;

    public Asunto() {
    }

    public Asunto(int codigo, Date fechaInicio, Date fechaFinalizacion, String estado, String cedulaClientefk) {
        this.codigo = codigo;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.estado = estado;
        this.cedulaClientefk = cedulaClientefk;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCedulaClientefk() {
        return cedulaClientefk;
    }

    public void setCedulaClientefk(String cedulaClientefk) {
        this.cedulaClientefk = cedulaClientefk;
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Asunto other = (Asunto) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "Asunto{" + "codigo=" + codigo + ", fechaInicio=" + fechaInicio + ", fechaFinalizacion=" + fechaFinalizacion + ", estado=" + estado + ", cedulaClientefk=" + cedulaClientefk + '}';
    }
}
