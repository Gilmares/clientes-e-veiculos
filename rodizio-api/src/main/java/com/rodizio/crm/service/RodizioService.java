package com.rodizio.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.rodizio.crm.model.RodizioSemana;

import reactor.core.publisher.Mono;


@Service
public class RodizioService {
	
	@Autowired
	private WebClient webClientRodizio;
	
	@Autowired
	private WebClient webClientVeiculos;
	
	public RodizioSemana obterPorCodigo(long codigoRodizio) {
		
		Mono<RodizioSemana> monoRodizio = this.webClientRodizio
		    .method(HttpMethod.GET) 
		    .uri("/clientes/{codigo}", codigoRodizio)
		    .retrieve()
		    .bodyToMono(RodizioSemana.class);
		
		Mono<RodizioSemana> monoVeiculos = this.webClientVeiculos
			    .method(HttpMethod.GET) 
			    .uri("/add/{codigo}", codigoRodizio)
			    .retrieve()
			    .bodyToMono(RodizioSemana.class);
		
		RodizioSemana nome = monoRodizio.block();
		RodizioSemana marca = monoVeiculos.block();
		
		return null;
	}
}