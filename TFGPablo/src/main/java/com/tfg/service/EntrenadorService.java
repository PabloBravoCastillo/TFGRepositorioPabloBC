package com.tfg.service;

import java.util.List;
import java.util.Optional;

import com.tfg.model.Clases;
import com.tfg.model.Entrenador;
import com.tfg.model.Usuario;

public interface EntrenadorService {
	public Entrenador save( Entrenador entrenador);
	Optional<Entrenador> findById(Integer id);
	public Entrenador buscarEporID(Integer id);
	public Entrenador buscarporID(Integer id);
	public Optional<Entrenador> get(Integer id);
	public void update(Entrenador producto);
	public void delete(Integer id);
	public List<Entrenador> findAll();
	public List<Entrenador> mostrarentrenadores();
	public Entrenador findByIdUsuario(int id);
	public List<Entrenador> buscarEntreDeUnaCategor(int idCategoria);
}
