package com.tfg.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.tfg.model.Entrenador;
import com.tfg.model.Modalidad;
import com.tfg.repository.IEntrenadorRepository;
import com.tfg.repository.IModalidadRepository;

@Service
public class ModalidadServiceImpl implements ModalidadService{
	@Autowired
	private IModalidadRepository modalidadRepository;

	@Override
	public Modalidad findById(Integer id) {
	    Optional<Modalidad> optionalModalidad = modalidadRepository.findById(id);
	    return optionalModalidad.orElse(null); // O devuelve null si no se encuentra una Modalidad
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
	public List<Date> mostrarModalidadesCategoriadeunEntrenador(int idCategoria, int idEntrenador){
		return modalidadRepository.mostrarModalidadesCategoriadeunEntrenador(idCategoria,idEntrenador);
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
