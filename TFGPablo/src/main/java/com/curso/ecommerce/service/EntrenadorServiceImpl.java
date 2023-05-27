package com.curso.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.ecommerce.model.Clases;
import com.curso.ecommerce.model.Entrenador;
import com.curso.ecommerce.model.Usuario;
import com.curso.ecommerce.repository.IEntrenadorRepository;



@Service
public class EntrenadorServiceImpl implements EntrenadorService {
	@Autowired
	private IEntrenadorRepository entrenadorRepository;

	@Override
	public Optional<Entrenador> findById(Integer id) {
		return entrenadorRepository.findById(id);
	}

	
	@Override
	public Optional<Entrenador> get(Integer id) {
		return entrenadorRepository.findById(id);
	}

	@Override
	public Entrenador save(Entrenador entrenador) {
		return entrenadorRepository.save(entrenador);
	}

	
	@Override
	public List<Entrenador> findAll() {
		return entrenadorRepository.findAll();
	}
	
	public List<Entrenador> mostrarentrenadores() {
		return entrenadorRepository.findAll();
	}
	
	@Override
	public Entrenador findByIdUsuario(int id) {
		return entrenadorRepository.findByIdUsuario(id);
	}



	@Override
	public void update(Entrenador entrenador) {
		// TODO Auto-generated method stub
		entrenadorRepository.save(entrenador);
	}
	
	

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
}
