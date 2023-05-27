package com.curso.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.curso.ecommerce.model.Clases;

public interface ClasesService {
	public Clases save( Clases producto);
	public Optional<Clases> get(Integer id);
	public void update(Clases producto);
	public void delete(Integer id);
	public List<Clases> findAll();
	public List<Clases> listar();
	

}
