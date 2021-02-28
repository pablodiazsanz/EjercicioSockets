package com.psp.concesionarioRestTemplate.modelo.proxy;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.psp.concesionarioRestTemplate.modelo.entidad.Coche;

public class CocheProxy {

	public static final String URL_CONCESIONARIO = "http://localhost:8080/concesionario/";

	public List<Coche> listar() {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Coche[]> response = restTemplate.getForEntity(URL_CONCESIONARIO, Coche[].class);

		Coche[] arrayPersonas = response.getBody();

		List<Coche> lista = Arrays.asList(arrayPersonas);

		return lista;
	}

	public Coche obtener(int id) {
		RestTemplate restTemplate = new RestTemplate();

		String personaResourceUrl = URL_CONCESIONARIO + id;

		ResponseEntity<Coche> response = restTemplate.getForEntity(personaResourceUrl, Coche.class);

		return response.getBody();
	}

	public Coche alta(Coche coche) {
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<Coche> requestBody = new HttpEntity<>(coche);

		Coche cCreado = restTemplate.postForObject(URL_CONCESIONARIO, requestBody, Coche.class);

		return cCreado;
	}

	public Coche modificar(Coche coche) {
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<Coche> requestBody = new HttpEntity<>(coche);

		ResponseEntity<Coche> response = restTemplate.exchange(URL_CONCESIONARIO + coche.getId(), HttpMethod.PUT,
				requestBody, Coche.class);

		return response.getBody();
	}

	public void borrar(int id) {
		RestTemplate restTemplate = new RestTemplate();

		restTemplate.delete(URL_CONCESIONARIO + id);
	}
}