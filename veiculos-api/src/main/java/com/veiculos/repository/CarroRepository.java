package com.veiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veiculos.model.Carro;



@Repository 
public interface CarroRepository extends JpaRepository<Carro, Long> {

}
