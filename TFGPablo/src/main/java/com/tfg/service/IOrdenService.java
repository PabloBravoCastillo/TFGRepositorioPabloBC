package com.tfg.service;

import java.util.List;
import java.util.Optional;

import com.tfg.model.Orden;
import com.tfg.model.Usuario;

public interface IOrdenService {
	List<Orden> findAll();
	Optional<Orden> findById(Integer id);
	Orden save (Orden orden);
	String generarNumeroOrden();
	List<Orden> findByUsuario (Usuario usuario);
}
