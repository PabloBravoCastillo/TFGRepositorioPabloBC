package com.curso.ecommerce.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.curso.ecommerce.model.Clases;
import com.curso.ecommerce.model.Entrenador;
import com.curso.ecommerce.model.Modalidad;
import com.curso.ecommerce.model.Orden;
import com.curso.ecommerce.model.Usuario;
import com.curso.ecommerce.service.ClasesService;
import com.curso.ecommerce.service.EntrenadorService;
import com.curso.ecommerce.service.IOrdenService;
import com.curso.ecommerce.service.ModalidadService;
import com.curso.ecommerce.service.IEntrenadorService;
import com.curso.ecommerce.service.UploadFileService;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {

	@Autowired
	private ClasesService clasesService;
	
	@Autowired
	private EntrenadorService entrenadorService;
	
	@Autowired
	private IEntrenadorService usuarioService;
	
	@Autowired
	private ModalidadService modalidadService;
	
	@Autowired
	private IOrdenService ordensService;
	
	@Autowired
	private UploadFileService upload;
	
	private Logger logg= LoggerFactory.getLogger(AdministradorController.class);

	@GetMapping("")
	public String home(Model model) {

		List<Clases> clases = clasesService.listar();
		model.addAttribute("productos", clases);


		return "administrador/home";
	}
	
	@PostMapping("/actualizarPerfil")
	public String save(Entrenador entrenador, @RequestParam("img") MultipartFile file, HttpSession session) throws IOException {
		Entrenador e= new Entrenador();
		e=entrenadorService.get(entrenador.getId()).get();
		System.out.println(entrenador);
		if (file.isEmpty()) { // editamos el producto pero no cambiamos la imagem
			
			entrenador.setImagen(e.getImagen());
		}else {// cuando se edita tbn la imagen			
			//eliminar cuando no sea la imagen por defecto
			if (!e.getImagen().equals("default.jpg")) {
				upload.deleteImage(e.getImagen());
			}
			String nombreImagen= upload.saveImage(file);
			entrenador.setImagen(nombreImagen);
		}
		entrenador.setUsuario(e.getUsuario());
		
		
		entrenadorService.update(entrenador);	
		return "redirect:/administrador/perfil";
	}
	
	@GetMapping("/perfil")
	public String perfil(Model model, HttpSession session) {
		
		Usuario usuario =usuarioService.findById( Integer.parseInt(session.getAttribute("idusuario").toString())).get();
		model.addAttribute("usuarios", usuario);
		Entrenador entrenador = entrenadorService.findByIdUsuario(usuario.getId());
		model.addAttribute("entrenadorsele", entrenador);
		return "administrador/entrenador";
		
	}
	
	@GetMapping("/entrenamientos")
	public String entrenamientos(Model model, HttpSession session) {
		
		Usuario usuario =usuarioService.findById( Integer.parseInt(session.getAttribute("idusuario").toString())).get();
		int idUsuario = usuario.getId();
		Entrenador entrenador = entrenadorService.findByIdUsuario(usuario.getId());
		int idEntrenador = entrenador.getId();
		
		model.addAttribute("modalidades", modalidadService.mostrarModalidadesPESTENTRE(idEntrenador));
		return "administrador/modalidad";
		
	}
	
	@GetMapping("/usuarios")
	public String usuarios(Model model) {
		model.addAttribute("usuarios", usuarioService.findAll());
		return "administrador/usuarios";
	}
	
	@GetMapping("/ordenes")
	public String ordenes(Model model) {
		model.addAttribute("ordenes", ordensService.findAll());
		return "administrador/ordenes";
	}
	
	@GetMapping("/detalle/{id}")
	public String detalle(Model model, @PathVariable Integer id) {
		logg.info("Id de la orden {}",id);
		Orden orden= ordensService.findById(id).get();
		
		model.addAttribute("detalles", orden.getDetalle());
		
		return "administrador/detalleorden";
	}
	
	
}
