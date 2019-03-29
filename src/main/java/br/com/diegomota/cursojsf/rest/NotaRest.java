package br.com.diegomota.cursojsf.rest;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.diegomota.cursojsf.dto.NotaDTO;


@Service
public class NotaRest {
	
	private RestTemplate restTemplate;
	private String url_api;
	
	public NotaRest() {
		restTemplate = new RestTemplate();
		url_api = "http://www.deveup.com.br/notas/api/notes";
	}
	
	
	public List<NotaDTO> listar() {
		ResponseEntity<List<NotaDTO>> response = 
                restTemplate.exchange(
                url_api,            
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<NotaDTO>>() { }
                );
		
		return response.getBody();
	}
	
	public NotaDTO buscarPorId(int id) {
		ResponseEntity<NotaDTO> response = restTemplate.exchange(url_api+"/{id}", HttpMethod.GET, null, new ParameterizedTypeReference<NotaDTO>() {}, id);
		return response.getBody();
	}
	
	
}
