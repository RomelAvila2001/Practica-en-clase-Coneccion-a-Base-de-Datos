/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.Objects;

/**
 *
 * @author NANCY
 */
public class Procurador {
    private String cedula;
    private String nombre;
    private String apellido;
    private int codigofk;

    public Procurador() {
    }

    public Procurador(String cedula, String nombre, String apellido, int codigofk) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigofk = codigofk;
    }

    

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCodigofk() {
        return codigofk;
    }

    public void setCodigofk(int codigofk) {
        this.codigofk = codigofk;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.cedula);
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
        final Procurador other = (Procurador) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Procurador{" + "cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", codigofk=" + codigofk + '}';
    }

    
}
