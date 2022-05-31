package org.jazziel.controladores;

import org.jazziel.entidades.Objetos;
import org.jazziel.entidades.Pokemon;
import org.jazziel.servicios.ObjetoServicios;
import org.jazziel.servicios.PokemonServicio;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/objeto/v1/")
@RestController

public class ObjetoController {

    @GetMapping(value="/getObjeto/{idObjeto}")
    public Objetos getObjetoNombre(@PathVariable String idObjeto) throws JSONException {
        return ObjetoServicios.getObjectbyId(idObjeto);
    }

    @GetMapping(value="/spriteObjeto/{idObjeto}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getSpriteObjeto(@PathVariable String idObjeto) throws JSONException {
        return ObjetoServicios.getImageByIdName(idObjeto);
    }
}
