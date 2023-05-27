package com.curso.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.curso.ecommerce.model.Clases;
import com.curso.ecommerce.model.Entrenador;
import com.curso.ecommerce.model.Usuario;

public interface EntrenadorService {
	public Entrenador save( Entrenador entrenador);
	Optional<Entrenador> findById(Integer id);
	public Optional<Entrenador> get(Integer id);
	public void update(Entrenador producto);
	public void delete(Integer id);
	public List<Entrenador> findAll();
	public List<Entrenador> mostrarentrenadores();
	public Entrenador findByIdUsuario(int id);
}
