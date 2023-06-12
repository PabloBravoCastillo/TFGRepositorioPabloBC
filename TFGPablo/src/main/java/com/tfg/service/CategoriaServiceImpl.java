package com.tfg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.model.Categoria;
import com.tfg.model.Clases;
import com.tfg.repository.ICategoriaRepository;
import com.tfg.repository.IClasesRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private ICategoriaRepository categoriaRepository;
	
	
	@Override
	public Categoria save(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@Override
	public Optional<Categoria> get(Integer id) {
		return categoriaRepository.findById(id);
	}

	@Override
	public void update(Categoria categoria) {
		categoriaRepository.save(categoria);		
	}

	@Override
	public void delete(Integer id) {
		categoriaRepository.deleteById(id);		
	}

	@Override
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	@Override
	public List<Categoria> listar() {
		// TODO Auto-generated method stub
		return categoriaRepository.listar();
	}
	
	public Categoria findbyIdCategoria(int categoria_id){
		return categoriaRepository.findbyIdCategoria( categoria_id);
	}
	
	public List  <Categoria> otrasCategorias(int categoria_id){
		return categoriaRepository.otrasCategorias(categoria_id);
	}
	
	
}
