package com.tfg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.tfg.model.Entrenador;
import com.tfg.model.Usuario;

public interface IEntrenadorService {
	List<Usuario> findAll();
	Optional<Usuario> findById(Integer id);
	Usuario save (Usuario usuario);
	Optional<Usuario> findByEmail(String email);
	List <Entrenador> findbyIdCategoria (@Param("id_categoria") int idCategoria);

}
