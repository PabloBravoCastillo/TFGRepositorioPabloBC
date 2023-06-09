package com.tfg.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tfg.model.Modalidad;

public interface IModalidadRepository extends JpaRepository<Modalidad, Integer> {
	@Query(value="SELECT * FROM Modalidad Where entrenador_id =:id", nativeQuery = true)
	List<Modalidad> mostrarModalidadesPESTENTRE(@Param("id") int id);
	
	
	@Query(value="SELECT DISTINCT date FROM Modalidad Where entrenador_id =:idEntrenador and categoria_id_categoria=:idCategoria", nativeQuery = true)
	List<Date> mostrarModalidadesCategoriadeunEntrenador(@Param("idCategoria")int idCategoria,@Param("idEntrenador") int idEntrenador);
	
	
}
