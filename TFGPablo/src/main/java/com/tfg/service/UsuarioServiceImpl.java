package com.tfg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.tfg.model.Usuario;
import com.tfg.repository.IEntrenadorRepository;
import com.tfg.repository.IUsuarioRepository;

@Service
public class UsuarioServiceImpl implements IEntrenadorService {

	@Autowired
	private IEntrenadorRepository entrenadorRepository;
	
	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	public Optional<Usuario> findById(Integer id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Optional<Usuario> findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	
	public List<Usuario> obtenerUsuariosQueCompraronClaseDeEntrenador(@Param("idEntrenador") int idEntrenador){
		return usuarioRepository.obtenerUsuariosQueCompraronClaseDeEntrenador( idEntrenador);
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	
}
