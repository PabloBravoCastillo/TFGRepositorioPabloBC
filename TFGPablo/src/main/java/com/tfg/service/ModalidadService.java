package com.tfg.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.tfg.model.Modalidad;

public interface ModalidadService {
	public Modalidad save( Modalidad modalidad);
	public Modalidad findById(Integer id);
	public Optional<Modalidad> get(Integer id);
	public void update(Modalidad modalidad);
	public void delete(Integer id);
	public List<Modalidad> findAll();
	public List<Modalidad> mostrarentrenadores();
	public List<Modalidad> mostrarModalidadesPESTENTRE(int id);
	public List<Date> mostrarModalidadesCategoriadeunEntrenador(int idCategoria, int idEntrenador);
	
}
