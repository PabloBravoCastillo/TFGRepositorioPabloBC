package com.curso.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.curso.ecommerce.model.Modalidad;

public interface ModalidadService {
	public Modalidad save( Modalidad modalidad);
	Optional<Modalidad> findById(Integer id);
	public Optional<Modalidad> get(Integer id);
	public void update(Modalidad modalidad);
	public void delete(Integer id);
	public List<Modalidad> findAll();
	public List<Modalidad> mostrarentrenadores();
	public List<Modalidad> mostrarModalidadesPESTENTRE(int id);
}
