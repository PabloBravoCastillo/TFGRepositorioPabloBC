package com.tfg.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tfg.model.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
	Optional<Usuario> findByEmail(String email);
	
	@Query(value = "SELECT u.* FROM usuarios u WHERE u.id IN (SELECT o.usuario_id FROM clases AS c JOIN detalles AS d ON c.id = d.clases_id JOIN ordenes AS o ON d.orden_id = o.id JOIN modalidad AS m ON c.modalidad_id = m.id WHERE c.entrenador_id = :idEntrenador)", nativeQuery = true)
	List<Usuario> obtenerUsuariosQueCompraronClaseDeEntrenador(@Param("idEntrenador") int idEntrenador);
}

