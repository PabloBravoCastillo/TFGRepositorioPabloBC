package com.tfg.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tfg.model.Clases;
import com.tfg.model.Entrenador;
import com.tfg.model.Orden;
import com.tfg.model.Usuario;
import com.tfg.service.ClasesService;
import com.tfg.service.EntrenadorService;
import com.tfg.service.IEntrenadorService;
import com.tfg.service.IOrdenService;
import com.tfg.service.UploadFileService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	private final Logger logger= LoggerFactory.getLogger(UsuarioController.class);
	@Autowired
	private ClasesService clasesService;
	
	@Autowired
	private IEntrenadorService usuarioService;
	
	@Autowired
	private IOrdenService ordenService;
	
	@Autowired
	private EntrenadorService entrenadorService;
	
	@Autowired
	private UploadFileService upload;
	
	BCryptPasswordEncoder passEncode= new BCryptPasswordEncoder();
	
	
	// /usuario/registro
	@GetMapping("/registro")
	public String create() {
		return "usuario/registro";
	}
	
	@PostMapping("/save")
	public String save(Usuario usuario) {
		logger.info("Usuario registro: {}", usuario);
		usuario.setTipo("USER");
		usuario.setPassword( passEncode.encode(usuario.getPassword()));
		usuarioService.save(usuario);		
		return "redirect:/";
	}
	
	@GetMapping("/citasProx")
	public String citasProx(Model model, HttpSession session) {
		model.addAttribute("sesion", session.getAttribute("idusuario"));
		Usuario usuario =usuarioService.findById( Integer.parseInt(session.getAttribute("idusuario").toString())).get();
		int idUsu=usuario.getId();
		System.out.println(idUsu);
		model.addAttribute("citasProx", clasesService.mostarClasesReservadasUsuario(idUsu));
		
		return "usuario/citasProx";

	}
	
	@GetMapping("/citasPen")
	public String citasPen(Model model, HttpSession session) {
		model.addAttribute("sesion", session.getAttribute("idusuario"));
		Usuario usuario =usuarioService.findById( Integer.parseInt(session.getAttribute("idusuario").toString())).get();
		int idUsu=usuario.getId();
		System.out.println(idUsu);
		model.addAttribute("citasProx", clasesService.mostarClasesPorConfirmarUsuario(idUsu));
		
		return "usuario/citasPen";

	}
	
	@GetMapping("/login")
	public String login() {
		return "usuario/login";
	}
	
	@GetMapping("/acceder")
	public String acceder(Usuario usuario, HttpSession session) {
		logger.info("Accesos : {}", usuario);
		
		Optional<Usuario> user=usuarioService.findById(Integer.parseInt(session.getAttribute("idusuario").toString()));
		//logger.info("Usuario de db: {}", user.get());
		
		if (user.isPresent()) {
			session.setAttribute("idusuario", user.get().getId());
			
			if (user.get().getTipo().equals("ADMIN")) {
				return "redirect:/administrador";
			}else {
				return "redirect:/";
			}
		}else {
			logger.info("Usuario no existe");
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/compras")
	public String obtenerCompras(Model model, HttpSession session) {
		model.addAttribute("sesion", session.getAttribute("idusuario"));
		
		Usuario usuario= usuarioService.findById(  Integer.parseInt(session.getAttribute("idusuario").toString()) ).get();
		List<Orden> ordenes= ordenService.findByUsuario(usuario);
		logger.info("ordenes {}", ordenes);
		
		model.addAttribute("ordenes", ordenes);
		
		return "usuario/compras";
	}
	
	@GetMapping("/perfil")
	public String perfil(Model model, HttpSession session) {
		model.addAttribute("sesion", session.getAttribute("idusuario"));
		Usuario usuario =usuarioService.findById( Integer.parseInt(session.getAttribute("idusuario").toString())).get();
		model.addAttribute("usuario", usuario);
		return "usuario/perfil";
		
	}
	
	@PostMapping("/actualizarPerfil")
	public String actualizarPerfil(Usuario usuario, HttpSession session) {
		Usuario u= new Usuario();
		u=usuarioService.findById(usuario.getId()).get();
		usuario.setPassword(u.getPassword());
		

		
		
		usuarioService.save(usuario);	
		return "redirect:/usuario/perfil";
		
	}
	
	
	@GetMapping("/solicitarEntrenador")
	public String solicitarEntrenador(Model model, HttpSession session) {
		model.addAttribute("sesion", session.getAttribute("idusuario"));
		Usuario usuario =usuarioService.findById( Integer.parseInt(session.getAttribute("idusuario").toString())).get();
	
		return "usuario/crearEntrenador";
		
	}
	
	@PostMapping("/crearPerfilEntrenador")
	public String crearPerfilEntrenador(Model model, Entrenador entrenador, @RequestParam("img") MultipartFile file, HttpSession session) throws IOException {
		model.addAttribute("sesion", session.getAttribute("idusuario"));
		Usuario usuario =usuarioService.findById( Integer.parseInt(session.getAttribute("idusuario").toString())).get();
		
			
			Usuario e= new Usuario();
			int idUsuario=usuario.getId();
			model.addAttribute("usuario", usuarioService.findById(idUsuario));
			entrenador.setUsuario(usuario);
			if (file.isEmpty()) { // editamos el producto pero no cambiamos la imagem
				
				entrenador.setImagen("default.jpg");
			}else {// cuando se edita tbn la imagen			
				
					
				String nombreImagen= upload.saveImage(file);
				entrenador.setImagen(nombreImagen);
			}
			
		
			usuario.setTipo("ADMIN");
			usuarioService.save(usuario);
			
			entrenadorService.save(entrenador);	
			return "redirect:/logout";
		}
	
	@GetMapping("/detalle/{id}")
	public String detalleCompra(@PathVariable Integer id, HttpSession session, Model model) {
		logger.info("Id de la orden: {}", id);
		Optional<Orden> orden=ordenService.findById(id);
		
		model.addAttribute("detalles", orden.get().getDetalle());
		
		
		//session
		model.addAttribute("sesion", session.getAttribute("idusuario"));
		return "usuario/detallecompra";
	}
	
	@GetMapping("/cerrar")
	public String cerrarSesion( HttpSession session ) {
		session.removeAttribute("idusuario");
		return "redirect:/";
	}
}
