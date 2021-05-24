package com.rodizio.crm.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;


import com.rodizio.crm.model.RodizioSemana;

import com.rodizio.crm.service.RodizioService;

@RestController
public class RodizioClienteController {
	
	@Autowired 
	private RodizioService rodizioService;
	
	@GetMapping("/clientes/{codigo}/add")
	public ResponseEntity<RodizioSemana> obterRodizioSemana(@PathVariable long codigo) {
		
		RodizioSemana rodizioSemana = this.rodizioService.obterPorCodigo(codigo);
		
		return ResponseEntity.ok(rodizioSemana);
	}
	
	
}