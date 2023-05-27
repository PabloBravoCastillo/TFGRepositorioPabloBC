package com.curso.ecommerce.controller;

import java.io.IOException;
import java.util.Optional;

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
import com.curso.ecommerce.model.Usuario;
import com.curso.ecommerce.service.ClasesService;
import com.curso.ecommerce.service.IEntrenadorService;
import com.curso.ecommerce.service.UploadFileService;

@Controller
@RequestMapping("/clases")
public class ClasesController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(ClasesController.class);
	
	@Autowired
	private ClasesService ClasesService;
	
	
	@Autowired
	private UploadFileService upload;
	
	@GetMapping("")
	public String show(Model model) {
		model.addAttribute("productos", ClasesService.findAll());
		return "clases/show";
	}
	
	@GetMapping("/create")
	public String create() {
		return "clases/create";
	}
	
	@PostMapping("/save")
	public String save(Clases clases, @RequestParam("img") MultipartFile file, HttpSession session) throws IOException {
		LOGGER.info("Este es el objeto producto {}",clases);
		
		
		Entrenador u= entrenadorService.findById(Integer.parseInt(session.getAttribute("idusuario").toString() )).get();
		clases.setEntrenador(u);	
		
		//imagen
		if (clases.getId()==null) { // cuando se crea un producto
			String nombreImagen= upload.saveImage(file);
			clases.setImagen(nombreImagen);
		}else {
			
		}
		
		ClasesService.save(clases);
		return "redirect:/clases";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Clases Clases= new Clases();
		Optional<Clases> optionalClases=ClasesService.get(id);
		Clases= optionalClases.get();
		
		LOGGER.info("Producto buscado: {}",Clases);
		model.addAttribute("producto", Clases);
		
		return "clases/edit";
	}
	
	@PostMapping("/update")
	public String update(Clases clases, @RequestParam("img") MultipartFile file ) throws IOException {
		Clases c= new Clases();
		c=ClasesService.get(clases.getId()).get();
		
		if (file.isEmpty()) { // editamos el producto pero no cambiamos la imagem
			
			clases.setImagen(c.getImagen());
		}else {// cuando se edita tbn la imagen			
			//eliminar cuando no sea la imagen por defecto
			if (!c.getImagen().equals("default.jpg")) {
				upload.deleteImage(c.getImagen());
			}
			String nombreImagen= upload.saveImage(file);
			clases.setImagen(nombreImagen);
		}
		clases.setEntrenador(c.getEntrenador());
		ClasesService.update(clases);		
		return "redirect:/clases";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		
		Clases c = new Clases();
		c=ClasesService.get(id).get();
		
		//eliminar cuando no sea la imagen por defecto
		if (!c.getImagen().equals("default.jpg")) {
			upload.deleteImage(c.getImagen());
		}
		
		ClasesService.delete(id);
		return "redirect:/clases";
	}
	
	
}
