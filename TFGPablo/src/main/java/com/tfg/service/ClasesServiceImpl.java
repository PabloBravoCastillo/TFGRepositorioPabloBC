package com.tfg.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.tfg.model.Clases;
import com.tfg.repository.IClasesRepository;

@Service
public class ClasesServiceImpl implements ClasesService{
	
	@Autowired
	private IClasesRepository clasesRepository;

	@Override
	public Clases save(Clases clase) {
		return clasesRepository.save(clase);
	}

	@Override
	public Optional<Clases> get(Integer id) {
		return clasesRepository.findById(id);
	}

	@Override
	public void update(Clases clase) {
		clasesRepository.save(clase);		
	}

	@Override
	public void delete(Integer id) {
		clasesRepository.deleteById(id);		
	}

	@Override
	public List<Clases> findAll() {
		return clasesRepository.findAll();
	}

	@Override
	public List<Clases> listar() {
		// TODO Auto-generated method stub
		return clasesRepository.listar();
	}
	@Override
	public List<Clases> buscarClasesDeEntrenadorActivadas(int entrenador_id){
		return clasesRepository.buscarClasesDeEntrenadorActivadas(entrenador_id);
	}
	@Override
	public List<Clases> buscarClasesDeEntrenadorDesactivadas(int entrenador_id){
		return clasesRepository.buscarClasesDeEntrenadorDesactivadas(entrenador_id);
	}
	
	@Override
	public List<Clases> findbyIdModalidad(int modalidad_id) {
		// TODO Auto-generated method stub
		return clasesRepository.findbyIdModalidad(modalidad_id);
	}

	@Override
	public List<Clases> mostrarHorasClasesdeunEntrenador(@Param("idCategoria")int idCategoria,@Param("idEntrenador") int idEntrenador,@Param("fecha") Date fecha){
		return clasesRepository.mostrarHorasClasesdeunEntrenador(idCategoria,idEntrenador,fecha);
	}
}
