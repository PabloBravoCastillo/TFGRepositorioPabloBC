package com.curso.ecommerce.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.curso.ecommerce.model.Entrenador;

@Repository
public interface IEntrenadorRepository extends JpaRepository<Entrenador, Integer> {
	
	@Query (value="SELECT * FROM Entrenador WHERE usuario_id = :id", nativeQuery = true)
	Entrenador findByIdUsuario (@Param("id") int id);
}
