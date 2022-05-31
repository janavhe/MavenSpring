package org.jazziel.controladores;

import org.jazziel.entidades.Pokemon;
import org.jazziel.servicios.PokemonServicio;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/spriteObjeto/v1/")
@RestController

public class SpritesObjeto {

    @GetMapping(value="/getObjeto/{nombrePokemon}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPokemon(@PathVariable String nombrePokemon) throws JSONException {
        return PokemonServicio.getImageByIdName(nombrePokemon);
    }
}
