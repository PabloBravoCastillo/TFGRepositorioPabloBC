package com.tfg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tfg.model.Categoria;
import com.tfg.model.Clases;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {
	@Query(value="SELECT * FROM categoria", nativeQuery = true)
	List<Categoria> listar();
	
	
	@Query(value="SELECT * FROM categoria where id_categoria=:categoria_id", nativeQuery = true)
	public  Categoria findbyIdCategoria(int categoria_id);
	
	
}
