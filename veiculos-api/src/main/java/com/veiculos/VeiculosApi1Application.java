package com.veiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VeiculosApi1Application {

	
	public static void main(String[] args) {
		SpringApplication.run(VeiculosApi1Application.class, args);
	}

}
