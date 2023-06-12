package com.tfg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.tfg.model.Clases;
import com.tfg.model.Entrenador;
import com.tfg.model.Usuario;
import com.tfg.repository.IEntrenadorRepository;



@Service
public class EntrenadorServiceImpl implements EntrenadorService {
	@Autowired
	private IEntrenadorRepository entrenadorRepository;

	@Override
	public Optional<Entrenador> findById(Integer id) {
	    return entrenadorRepository.findById(id);
	}
	
	public Entrenador buscarporID(Integer id) {
		 return entrenadorRepository.findById(id).get();
	}
	
	public Entrenador buscarEporID(Integer id) {
		 return entrenadorRepository.findById(id).get();
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
	
	public List<Entrenador> buscarEntreDeUnaCategor(int idCategoria) {
		return entrenadorRepository.buscarEntreDeUnaCategor(idCategoria);
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
