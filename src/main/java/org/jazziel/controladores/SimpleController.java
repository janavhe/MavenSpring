package org.jazziel.controladores;

import org.jazziel.entidades.Pokemon;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping(path = "/clase1/v1/")
@RestController
public class SimpleController {


    @GetMapping("/pokemonEjemplo")
    public Pokemon homePage() {
        Pokemon ejemploPokemon = new Pokemon("Pikachu", "Hombre");
        return ejemploPokemon;
    }

    @GetMapping("/pokemonEjemplo/{nombrePokemon}")
    public Pokemon pokemonPorUrl(@PathVariable String nombrePokemon) {
        Pokemon ejemploPokemon = new Pokemon(nombrePokemon, "Hombre");
        return ejemploPokemon;
    }

    @GetMapping("/sexoEjemplo/{sexoPokeon}")
    public Pokemon sexoPorUrl(@PathVariable String sexoPokeon) {
        Pokemon ejemploPokemon = new Pokemon("Pikachu", sexoPokeon);
        return ejemploPokemon;
    }

    @GetMapping("/robarInfo/{nombrePokemon}")
    public Pokemon robarInfo(@PathVariable String nombrePokemon) throws JSONException {
        String uri = "https://pokeapi.co/api/v2/pokemon/" + nombrePokemon;

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        JSONObject jsonObject= new JSONObject(result);

        String name = jsonObject.getString("name");
        String type = jsonObject.getJSONArray("types").getJSONObject(0).getJSONObject("type").getString("name");

        Pokemon ejemploPokemon = new Pokemon(name,type);
        return ejemploPokemon;
    }


}
