package com.tfg.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.tfg.model.Clases;

public interface ClasesService {
	public Clases save( Clases producto);
	public Optional<Clases> get(Integer id);
	public void update(Clases producto);
	public void delete(Integer id);
	public List<Clases> findAll();
	public List<Clases> listar();
	public List<Clases> buscarClasesDeEntrenadorActivadas(int entrenador_id);
	public List<Clases> buscarClasesDeEntrenadorDesactivadas(int entrenador_id);
	public List<Clases> findbyIdModalidad(int modalidad_id);
	public List<Clases> mostrarHorasClasesdeunEntrenador(int idCategoria, int idEntrenador, Date fecha);

}
