package org.jazziel.entidades;

import java.io.Serializable;

public class Pokemon implements Serializable {


    private String name;
    private String sexo;

    public Pokemon(String name, String sexo) {
        this.name = name;
        this.sexo = sexo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}
