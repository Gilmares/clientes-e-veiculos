package com.veiculos.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.veiculos.model.Carro;

@FeignClient(url= "https://parallelum.com.br/fipe/api/v1/carros/", name = "fipe")
public interface BuscaCarro {

	@GetMapping("{marcas}/json")
	Carro buscaCarroPorMarcas(@PathVariable("marcas") String marcas);

	

	



	
}
