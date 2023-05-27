package com.curso.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.curso.ecommerce.model.Clases;

@Repository
public interface IClasesRepository extends JpaRepository<Clases, Integer> {
	
	@Query(value="SELECT * FROM clases where categoria_id_categoria = 2", nativeQuery = true)
	List<Clases> listar();
}
