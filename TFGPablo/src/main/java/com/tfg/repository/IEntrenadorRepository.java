package com.tfg.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tfg.model.Entrenador;
import com.tfg.model.Usuario;

@Repository
public interface IEntrenadorRepository extends JpaRepository<Entrenador, Integer> {
	
	@Query (value="SELECT * FROM Entrenador WHERE usuario_id = :id", nativeQuery = true)
	Entrenador findByIdUsuario (@Param("id") int id);
	
	@Query (value="SELECT DISTINCT  entrenador.* FROM proyecto.entrenador JOIN proyecto.modalidad ON entrenador.id = modalidad.entrenador_id WHERE modalidad.categoria_id_categoria = :id_categoria", nativeQuery = true)
	List <Entrenador> buscarEntreDeUnaCategor (@Param("id_categoria") int idCategoria);
	
	
	
//	@Query (value="SELECT entrenador.* FROM proyecto.entrenador JOIN proyecto.modalidad ON entrenador.id = modalidad.entrenador_id WHERE modalidad.categoria_id_categoria = :id_categoria AND modalidad.entrenador_id = :id_categoria", nativeQuery = true)
//	List <Entrenador> findbyIdCategoria (@Param("id_categoria") int idCategoria);
	
}
