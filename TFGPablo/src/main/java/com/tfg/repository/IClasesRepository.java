package com.tfg.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tfg.model.Clases;

@Repository
public interface IClasesRepository extends JpaRepository<Clases, Integer> {
	
	@Query(value="SELECT * FROM clases", nativeQuery = true)
	List<Clases> listar();
	
	@Query(value="SELECT * FROM clases where modalidad_id=:modalidad_id order by id", nativeQuery = true)
	List<Clases> findbyIdModalidad(@Param("modalidad_id")int modalidad_id);

	
	@Query(value = "SELECT clases.* FROM clases INNER JOIN modalidad ON clases.modalidad_id = modalidad.id WHERE modalidad.entrenador_id = :entrenador_id AND clases.disponible = 1 AND clases.reservado = 1 AND clases.confirmado = 1 ORDER BY modalidad.date", nativeQuery = true)
	List<Clases> buscarClasesDeEntrenadorActivadas(@Param("entrenador_id") int entrenador_id);
	
	@Query(value = "SELECT clases.* FROM clases INNER JOIN modalidad ON clases.modalidad_id = modalidad.id WHERE modalidad.entrenador_id = :entrenador_id AND clases.disponible = 1 AND clases.reservado = 1 AND clases.confirmado = 0 ORDER BY modalidad.date", nativeQuery = true)
	List<Clases> buscarClasesDeEntrenadorDesactivadas(@Param("entrenador_id") int entrenador_id);

	@Query(value="SELECT c.* FROM Clases c INNER JOIN Modalidad m ON c.modalidad_id = m.id AND m.entrenador_id = c.entrenador_id WHERE m.entrenador_id = :idEntrenador AND m.categoria_id_categoria = :idCategoria AND m.date = :fecha ORDER BY c.horaInicio ASC", nativeQuery = true)
	List<Clases> mostrarHorasClasesdeunEntrenador(@Param("idCategoria")int idCategoria,@Param("idEntrenador") int idEntrenador,@Param("fecha") Date fecha);
	
	@Query(value="SELECT * FROM clases AS c JOIN detalles AS d ON c.id = d.clases_id JOIN ordenes AS o ON d.orden_id = o.id JOIN usuarios AS u ON o.usuario_id = u.id JOIN modalidad AS m ON c.modalidad_id = m.id WHERE u.id = :idusuario AND c.reservado = true AND c.confirmado = true AND c.disponible = true ORDER BY m.date DESC LIMIT 7",nativeQuery = true)
	List<Clases> mostarClasesReservadasUsuario(@Param("idusuario")int idusuario);
	
	@Query(value="SELECT * FROM clases AS c JOIN detalles AS d ON c.id = d.clases_id JOIN ordenes AS o ON d.orden_id = o.id JOIN usuarios AS u ON o.usuario_id = u.id JOIN modalidad AS m ON c.modalidad_id = m.id WHERE u.id = :idusuario AND c.reservado = true AND c.confirmado = false AND c.disponible = true ORDER BY m.date DESC LIMIT 7",nativeQuery = true)
	List<Clases> mostarClasesPorConfirmarUsuario(@Param("idusuario")int idusuario);

}
