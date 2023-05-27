package com.curso.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.ecommerce.model.Clases;
import com.curso.ecommerce.repository.IClasesRepository;

@Service
public class ClasesServiceImpl implements ClasesService{
	
	@Autowired
	private IClasesRepository productoRepository;

	@Override
	public Clases save(Clases producto) {
		return productoRepository.save(producto);
	}

	@Override
	public Optional<Clases> get(Integer id) {
		return productoRepository.findById(id);
	}

	@Override
	public void update(Clases producto) {
		productoRepository.save(producto);		
	}

	@Override
	public void delete(Integer id) {
		productoRepository.deleteById(id);		
	}

	@Override
	public List<Clases> findAll() {
		return productoRepository.findAll();
	}

	@Override
	public List<Clases> listar() {
		// TODO Auto-generated method stub
		return productoRepository.listar();
	}

}
