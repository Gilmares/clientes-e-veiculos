package com.veiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PostMapping;
//mport org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.veiculos.model.Carro;
import com.veiculos.repository.BuscaCarro;
import com.veiculos.repository.CarroRepository;


@RestController
@RequestMapping
public class BuscaRestCarro {
	
	@Autowired
	private BuscaCarro buscaCarro;
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Carro> getMarca(@PathVariable String marcas) {
	Carro carro = buscaCarro.buscaCarroPorMarcas(marcas);
    return carro != null ? ResponseEntity.ok().body(carro) : ResponseEntity.notFound().build(); 
}

	@Autowired
	private CarroRepository carroRepository;
	
	@PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
	public Carro adicionar(@RequestBody Carro carro) {
		return carroRepository.save(carro);
}

}






/*@RestController
public class TabelaRestFipe{
	
	@Autowired
	private TabelaFipe tabelaFipe;
	
	
	@GetMapping("/{marca}")
	public ResponseEntity<String> getMarca(@PathVariable String marca){
		Cliente cliente = tabelaFipe.buscaClientePorMarca(marca);
		return cliente != null ? ResponseEntity.ok().body(marca): ResponseEntity.notFound().build();
		
	}
	
	
	
	
	
}
/*@RestController
//@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired 
	private ClienteRepository clienteRepository;
	
	@GetMapping //responder o método 
	public List<Cliente> listar() {
		return clienteRepository.findAll();
		
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}

}*/
