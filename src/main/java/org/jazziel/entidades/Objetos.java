package org.jazziel.entidades;

import java.io.Serializable;

public class Objetos implements Serializable {


    public Objetos(String nombre, String efecto) {
        this.nombre = nombre;
        this.efecto = efecto;
    }

    private String nombre;
    private String efecto;

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getEfecto() {return efecto;}

    public void setEfecto(String efecto) {this.efecto = efecto;}

    @Override
    public String toString() {
        return "Objetos{" +
                "nombre='" + nombre + '\'' +
                ", efecto='" + efecto + '\'' +
                '}';
    }
}
