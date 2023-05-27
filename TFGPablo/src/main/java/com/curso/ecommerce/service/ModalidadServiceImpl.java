package com.curso.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.ecommerce.model.Entrenador;
import com.curso.ecommerce.model.Modalidad;
import com.curso.ecommerce.repository.IEntrenadorRepository;
import com.curso.ecommerce.repository.IModalidadRepository;

@Service
public class ModalidadServiceImpl implements ModalidadService{
	@Autowired
	private IModalidadRepository modalidadRepository;

	@Override
	public Optional<Modalidad> findById(Integer id) {
		return modalidadRepository.findById(id);
	}

	
	@Override
	public Optional<Modalidad> get(Integer id) {
		return modalidadRepository.findById(id);
	}

	@Override
	public Modalidad save(Modalidad modalidad) {
		return modalidadRepository.save(modalidad);
	}

	
	@Override
	public List<Modalidad> findAll() {
		return modalidadRepository.findAll();
	}
	
	public List<Modalidad> mostrarentrenadores() {
		return modalidadRepository.findAll();
	}
	
	@Override
	public List<Modalidad> mostrarModalidadesPESTENTRE(int id) {
		return modalidadRepository.mostrarModalidadesPESTENTRE(id);
	}


	@Override
	public void update(Modalidad modalidad) {
		// TODO Auto-generated method stub
		modalidadRepository.save(modalidad);
	}
	
	

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
}
}
