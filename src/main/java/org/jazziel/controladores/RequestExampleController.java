package org.jazziel.controladores;

import org.jazziel.entidades.Pokemon;
import org.jazziel.servicios.PokemonServicio;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RequestMapping(path = "/ejemploPeticiones/v1/")
@RestController
public class RequestExampleController {

    @GetMapping("/getPokemon/{nombrePokemon}")
    public Pokemon getPokemon(@PathVariable String nombrePokemon) throws JSONException {
        return PokemonServicio.getPokemonByIdName(nombrePokemon);
    }


    @GetMapping("/getPokemon")
    public Pokemon getPokemonByRequestParam(@RequestParam String nombrePokemon) throws JSONException {
        return PokemonServicio.getPokemonByIdName(nombrePokemon);
    }

    @PostMapping(value = "/getPokemonJson",produces = "application/json")
    public Pokemon getPokemonByRequestBodyJson(@RequestBody String jsonPokemon) throws JSONException {
        return PokemonServicio.getPokemonByJson(jsonPokemon);
    }

    @PostMapping("/getPokemon")
    public Pokemon getPokemonByRequestBody(@RequestBody String nombrePokemon) throws JSONException {
        return PokemonServicio.getPokemonByIdName(nombrePokemon);
    }

    @GetMapping("/evolutionPokemon/{idPokemon}")
    public Pokemon getEvolucionPokemon(@PathVariable String idPokemon) throws JSONException {
        return PokemonServicio.getPokemonEvolution(idPokemon);
    }

}
