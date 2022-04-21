package org.jazziel.controladores;

import org.jazziel.entidades.Pokemon;
import org.jazziel.servicios.PokemonServicio;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/spritePokemon/v1/")
@RestController
public class SpritesPokemonController {

    @GetMapping(value="/getPokemon/{nombrePokemon}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPokemon(@PathVariable String nombrePokemon) throws JSONException {
        return PokemonServicio.getImageByIdName(nombrePokemon);
    }


    @GetMapping(value="/getPokemon",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPokemonByRequestParam(@RequestParam String nombrePokemon, @RequestParam String tipo) throws JSONException {
        return PokemonServicio.getImageByIdName(nombrePokemon,tipo);
    }

    @PostMapping(value = "/getPokemonJson",produces = "application/json")
    public Pokemon getPokemonByRequestBodyJson(@RequestBody String jsonPokemon) throws JSONException {
        return PokemonServicio.getPokemonByJson(jsonPokemon);
    }

    @PostMapping("/getPokemon")
    public Pokemon getPokemonByRequestBody(@RequestBody String nombrePokemon) throws JSONException {
        return PokemonServicio.getPokemonByIdName(nombrePokemon);
    }

}
