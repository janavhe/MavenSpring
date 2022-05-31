package org.jazziel.entidades;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pokemon implements Serializable {


    private String name;
    private String tipo;
    private List <Pokemon> evolicion;

    public Pokemon(String name, String tipo) {
        this.name = name;
        this.tipo = tipo;
    }

    public Pokemon(String name, String tipo, List<Pokemon> evolicion) {
        this.name = name;
        this.tipo = tipo;
        this.evolicion = evolicion;
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

    public List<Pokemon> getEvolicion() {
        return evolicion;
    }

    public void setEvolicion(List<Pokemon> evolicion) {
        this.evolicion = evolicion;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", tipo='" + tipo + '\'' +
                ", evolicion=" + evolicion +
                '}';
    }

    public static List <Pokemon> buscarEvoluciones(JSONObject pokemon) throws JSONException {
        List <Pokemon> listaDeEvolusiones = new ArrayList<>();
        String name = pokemon.getJSONObject("species").getString("name");
        System.out.println(name);

        if (!pokemon.getJSONArray("evolves_to").isNull(0)) {
            listaDeEvolusiones.addAll(buscarEvoluciones(pokemon.getJSONArray("evolves_to").getJSONObject(0)));
        }
    listaDeEvolusiones.add(new Pokemon(name, "azul"));
        return listaDeEvolusiones;
    }

}
