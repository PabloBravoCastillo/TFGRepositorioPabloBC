package com.curso.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.curso.ecommerce.model.Modalidad;

public interface IModalidadRepository extends JpaRepository<Modalidad, Integer> {
	@Query(value="SELECT * FROM Modalidad Where entrenador_id =:id", nativeQuery = true)
	List<Modalidad> mostrarModalidadesPESTENTRE(@Param("id") int id);
}
