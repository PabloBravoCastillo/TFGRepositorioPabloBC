package com.tfg.service;

import java.util.List;
import java.util.Optional;

import com.tfg.model.Categoria;
import com.tfg.model.Clases;


public interface CategoriaService {
	public Categoria save( Categoria categoria);
	public Optional<Categoria> get(Integer id);
	public void update(Categoria categoria);
	public void delete(Integer id);
	public List<Categoria> findAll();
	public List<Categoria> listar();
	public Categoria findbyIdCategoria(int categoria_id);
	public  Categoria obtenerNombreCategoria(int categoria_id);
	public List  <Categoria> otrasCategorias(int categoria_id);
	
}
