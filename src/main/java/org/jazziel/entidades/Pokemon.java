package org.jazziel.entidades;

import java.io.Serializable;

public class Pokemon implements Serializable {


    private String name;
    private String tipo;

    public Pokemon(String name, String tipo) {
        this.name = name;
        this.tipo = tipo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", sexo='" + tipo + '\'' +
                '}';
    }
}
