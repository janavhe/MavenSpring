package org.jazziel.servicios;

import org.jazziel.entidades.Pokemon;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.client.RestTemplate;

public class PokemonServicio {

    public static Pokemon getPokemonByIdName(String nombrePokemon) throws JSONException {

        final String uri = "https://pokeapi.co/api/v2/pokemon/" + nombrePokemon;

        final RestTemplate restTemplate = new RestTemplate();
        final String result = restTemplate.getForObject(uri, String.class);
        JSONObject jsonObject= new JSONObject(result);

        String name = jsonObject.getString("name");
        String type = jsonObject.getJSONArray("types").getJSONObject(0).getJSONObject("type").getString("name");

        Pokemon ejemploPokemon = new Pokemon(name,type);
        return ejemploPokemon;
    }

    public static byte[] getImageByIdName(String nombrePokemon) throws JSONException {
        return getImageByIdName(nombrePokemon,"front_default");
    }

        public static byte[] getImageByIdName(String nombrePokemon, String tipoImagen) throws JSONException {

        final String uri = "https://pokeapi.co/api/v2/pokemon/" + nombrePokemon;

        final RestTemplate restTemplate = new RestTemplate();
        final String result = restTemplate.getForObject(uri, String.class);
        JSONObject jsonObject= new JSONObject(result);

        String urlImagen = jsonObject.getJSONObject("sprites").getString(tipoImagen);
        System.out.println(urlImagen);
        return restTemplate.getForObject(urlImagen,byte[].class);
    }


    public static Pokemon getPokemonByJson(String json) throws JSONException {
        JSONObject pokemonJsom = new JSONObject(json);
        System.out.println(pokemonJsom);
        return getPokemonByIdName(pokemonJsom.getString("nombrePokemon"));
    }
}
