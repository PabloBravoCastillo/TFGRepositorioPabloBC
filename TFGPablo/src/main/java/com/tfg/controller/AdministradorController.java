package com.tfg.controller;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tfg.model.Categoria;
import com.tfg.model.Clases;
import com.tfg.model.Entrenador;
import com.tfg.model.Modalidad;
import com.tfg.model.Orden;
import com.tfg.model.Usuario;
import com.tfg.service.CategoriaService;
import com.tfg.service.ClasesService;
import com.tfg.service.EntrenadorService;
import com.tfg.service.IEntrenadorService;
import com.tfg.service.IOrdenService;
import com.tfg.service.ModalidadService;
import com.tfg.service.UploadFileService;

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
	private CategoriaService categoriaService;
	
	@Autowired
	private ModalidadService modalidadService;
	
	@Autowired
	private IOrdenService ordensService;
	
	@Autowired
	private UploadFileService upload;
	
	private Logger logg= LoggerFactory.getLogger(AdministradorController.class);

	@GetMapping("")
	public String home(Model model, HttpSession session) {
		Usuario usuario =usuarioService.findById( Integer.parseInt(session.getAttribute("idusuario").toString())).get();
		int idUsuario = usuario.getId();
		Entrenador entrenador = entrenadorService.findByIdUsuario(usuario.getId());
		int idEntrenador = entrenador.getId();

		List<Clases> clases = clasesService.buscarClasesDeEntrenadorActivadas(idEntrenador);
		model.addAttribute("clases", clases);


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
	
	@PostMapping("/añadirDeporte")
	public String añadirDeporte(Categoria categoria, @RequestParam("img") MultipartFile file, HttpSession session) throws IOException {
		if (file.isEmpty()) { // editamos el producto pero no cambiamos la imagem
			
			categoria.setImagen("default.jpg");
		}else {// cuando se edita tbn la imagen			
			
				
			String nombreImagen= upload.saveImage(file);
			categoria.setImagen(nombreImagen);
		}
		
		
		categoriaService.save(categoria);
		return "redirect:/administrador/formularioDisponibilidad";
	}
	
	@GetMapping("/actividades")
	public String actividades(Model model, HttpSession session) {
model.addAttribute("modalidades", modalidadService.findAll());
		
		
		//session
		model.addAttribute("sesion", session.getAttribute("idusuario"));
		
		return "usuario/actividades";

	}
	
	@GetMapping("/entrenadores")
	public String entrenadores(Model model, HttpSession session) {
model.addAttribute("entrenadores", entrenadorService.findAll());
		
		
		//session
		model.addAttribute("sesion", session.getAttribute("idusuario"));
		
		return "usuario/entrenadores";

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
	
	
	@GetMapping("/formularioDisponibilidad")
	public String formularioDisponibilidad(Model model, HttpSession session) {
		
		Usuario usuario =usuarioService.findById( Integer.parseInt(session.getAttribute("idusuario").toString())).get();
		int idUsuario = usuario.getId();
		Entrenador entrenador = entrenadorService.findByIdUsuario(usuario.getId());
		int idEntrenador = entrenador.getId();
		model.addAttribute("modalidad", new Modalidad());
		model.addAttribute("categorias", categoriaService.listar() );
		 
		 
		
		return "administrador/formularioDisponibilidad";
		
	}
	
	
	
	
	@PostMapping("/guardarDisponibilidad")
    public String guardarModalidad(Modalidad modalidad, @RequestParam("img") MultipartFile file,
            HttpSession session, @RequestParam("intModalidad") int intModalidad, @RequestParam("intCategoria") int intCategoria, RedirectAttributes redirectAttributes)
            throws IOException {
        Usuario usuario = usuarioService.findById(Integer.parseInt(session.getAttribute("idusuario").toString()))
                .get();

        Entrenador entrenador = entrenadorService.findByIdUsuario(usuario.getId());
        Categoria categoria = categoriaService.findbyIdCategoria(intCategoria);
        
        String campoModalidad;
        if (intModalidad == 0) {
            campoModalidad = "Presencial";
        } else {
            campoModalidad = "Online";
        }
        modalidad.setEntrenador(entrenador);
        modalidad.setModalidad(campoModalidad);
        modalidad.setCategoria(categoria);
        if (file.isEmpty()) { // editamos el producto pero no cambiamos la imagen
            modalidad.setImagen("default.jpg");
        } else { // cuando se edita también la imagen
            String nombreImagen = upload.saveImage(file);
            modalidad.setImagen(nombreImagen);
        }
        modalidadService.save(modalidad);

        String completohoraIni = modalidad.getHoraInicio();
        String completohoraFin = modalidad.getHoraFin();
        boolean esPosible = true;
        int horaIni = Integer.parseInt(completohoraIni.substring(0, 2));
        int horaFin = Integer.parseInt(completohoraFin.substring(0, 2));
        int minIni = Integer.parseInt(completohoraIni.substring(3, 5));
        int minFin = Integer.parseInt(completohoraFin.substring(3, 5));
        int duracionClase = modalidad.getDuracion();
        int intervalo = modalidad.getIntervaloentreclases();
        int horaActual = horaIni;
        int minActual = minIni;
        while (esPosible) {
            // Verificar si es posible generar otra clase

            // Incrementar la hora actual y los minutos actuales
            minActual += duracionClase;
            horaActual += minActual / 60;
            minActual %= 60;

            // Verificar si se supera la hora de finalización
            if (horaActual > horaFin || (horaActual == horaFin && minActual > minFin)) {
                esPosible = false;
                break;
            }

            // Imprimir "Clase generada"
            Clases clases = new Clases();
            clases.setEntrenador(entrenador);
            
            clases.setNombre(categoria.getNombre());
            clases.setDescripcion(modalidad.getDescripcion());
            clases.setImagen(modalidad.getImagen());
            clases.setPrecio(modalidad.getPrecio());
            clases.setModalidad(modalidad);
            clases.setEntrenador(entrenador);

            // Ajustar los minutos si superan los 60
            int horasCompletas = minActual / 60;
            minActual %= 60;

            // Añadir las horas completas al contador de horas
            horaActual += horasCompletas;

            // Crear objetos LocalTime para la hora de inicio y fin
         // Crear objetos LocalTime para la hora de inicio y fin
            LocalTime horaInicio = LocalTime.of(horaActual, minActual);
            LocalTime horaFinClase = horaInicio.plusMinutes(duracionClase);

            // Guardar la hora y los minutos en forma de string
            String horaInicioString = horaInicio.format(DateTimeFormatter.ofPattern("HH:mm"));
            String horaFinString = horaFinClase.format(DateTimeFormatter.ofPattern("HH:mm"));

            // Asignar las horas de inicio y fin a la clase
            clases.setHoraInicio(horaInicioString);
            clases.setHoraFin(horaFinString);


            clasesService.save(clases);

            // Incrementar la hora actual y los minutos actuales con el intervalo entre clases
            minActual += intervalo;
            horaActual += minActual / 60;
            minActual %= 60;

            // Verificar si se supera la hora de finalización después del intervalo
            if (horaActual > horaFin || (horaActual == horaFin && minActual > minFin)) {
                esPosible = false;
                break;
            }

            // Verificar si es posible generar más clases
            if (horaActual < horaFin || (horaActual == horaFin && minActual <= minFin)) {
                esPosible = true;
            } else {
                esPosible = false;
                break;
            }
        }



        redirectAttributes.addFlashAttribute("mensaje", "Clases generadas exitosamente.");

        return "redirect:/administrador/entrenamientos";
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
