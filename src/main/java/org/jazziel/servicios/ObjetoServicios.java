package org.jazziel.servicios;

import org.jazziel.entidades.Objetos;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.client.RestTemplate;

public class ObjetoServicios {

    public static Objetos getObjectbyId(String idObjeto) throws JSONException{

        final String uri = "https://pokeapi.co/api/v2/item/" + idObjeto;
        final RestTemplate restTemplate = new RestTemplate();
        final String result = restTemplate.getForObject(uri, String.class);
        JSONObject jsonObject= new JSONObject(result);

        String name = jsonObject.getJSONArray("names").getJSONObject(7).getString("name");
        String efecto = jsonObject.getJSONArray("effect_entries").getJSONObject(0).getString("effect");

        Objetos objeto =new Objetos(name,efecto);
        return objeto;
    }

    public static byte[] getImageByIdName(String idObjeto) throws JSONException {

        final String uri = "https://pokeapi.co/api/v2/item/" + idObjeto;

        final RestTemplate restTemplate = new RestTemplate();
        final String result = restTemplate.getForObject(uri, String.class);
        JSONObject jsonObject= new JSONObject(result);

        String urlImagen = jsonObject.getJSONObject("sprites").getString("default");
        return restTemplate.getForObject(urlImagen,byte[].class);
    }
}
