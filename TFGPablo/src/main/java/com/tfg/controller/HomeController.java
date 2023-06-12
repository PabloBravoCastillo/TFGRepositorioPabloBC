package com.tfg.controller;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
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

import com.tfg.model.Clases;
import com.tfg.model.DetalleOrden;
import com.tfg.model.Modalidad;
import com.tfg.model.Orden;
import com.tfg.model.Usuario;
import com.tfg.service.CategoriaService;
import com.tfg.service.ClasesService;
import com.tfg.service.EntrenadorService;
import com.tfg.service.IDetalleOrdenService;
import com.tfg.service.IEntrenadorService;
import com.tfg.service.IOrdenService;
import com.tfg.service.ModalidadService;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/")
public class HomeController {

	private final Logger log = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private ClasesService clasesService;
	
	@Autowired
	private EntrenadorService entrenadorService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private IEntrenadorService usuarioService;
	
	@Autowired
	private ModalidadService modalidadService;
	
	@Autowired
	private IOrdenService ordenService;
	
	@Autowired
	private IDetalleOrdenService detalleOrdenService;

	// para almacenar los detalles de la orden
	List<DetalleOrden> detalles = new ArrayList<DetalleOrden>();

	// datos de la orden
	Orden orden = new Orden();

	@GetMapping("")
	public String home(Model model, HttpSession session) {
		
		log.info("Sesion del usuario: {}", session.getAttribute("idusuario"));
		
		model.addAttribute("categorias", categoriaService.listar());
		
		
		//session
		model.addAttribute("sesion", session.getAttribute("idusuario"));

		return "usuario/home";
	}

	
	
	
	@GetMapping("/activiad/{id}")
	public String detallesModalidad(@PathVariable("id") int id,Model model, HttpServletRequest request, Authentication authentication, HttpSession session) {
		model.addAttribute("actividad", categoriaService.findbyIdCategoria(id));
		model.addAttribute("entrenadores", entrenadorService.buscarEntreDeUnaCategor(id));
		model.addAttribute("sesion", session.getAttribute("idusuario"));
		model.addAttribute("otrasActividades", categoriaService.otrasCategorias(id));
		
		return "usuario/actividades";

	}
	
	@GetMapping("/entrenador/{idEntrenador}/{idCategoria}")
	public String detallesDisponibilidad(@PathVariable("idEntrenador") int idEntrenador,@PathVariable("idCategoria") int idCategoria,Model model, HttpServletRequest request, Authentication authentication, HttpSession session) {
		model.addAttribute("entrenador", entrenadorService.buscarporID(idEntrenador));
		model.addAttribute("actividad", categoriaService.findbyIdCategoria(idCategoria));
		model.addAttribute("modalidades", modalidadService.mostrarModalidadesCategoriadeunEntrenador(idCategoria,idEntrenador));
		System.out.println(modalidadService.mostrarModalidadesCategoriadeunEntrenador(idCategoria,idEntrenador));
		model.addAttribute("sesion", session.getAttribute("idusuario"));
		model.addAttribute("otrasActividades", categoriaService.otrasCategorias(idCategoria));
		
		return "usuario/entrenadorDisponibilidad1";

	}
	
	@GetMapping("/entrenador/{idEntrenador}/{idCategoria}/{fecha}")
	public String detallesDisponibilidad2(@PathVariable("idEntrenador") int idEntrenador, @PathVariable("idCategoria") int idCategoria, @PathVariable("fecha") String fecha, Model model, HttpServletRequest request, Authentication authentication, HttpSession session) {
	    model.addAttribute("entrenador", entrenadorService.buscarporID(idEntrenador));
	    model.addAttribute("actividad", categoriaService.findbyIdCategoria(idCategoria));
	    model.addAttribute("modalidades", modalidadService.mostrarModalidadesCategoriadeunEntrenador(idCategoria, idEntrenador));
	    model.addAttribute("otrasActividades", categoriaService.otrasCategorias(idCategoria));

	    java.sql.Date fechaSql = null;
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    try {
	        java.util.Date parsedDate = dateFormat.parse(fecha);
	        fechaSql = new java.sql.Date(parsedDate.getTime());
	        model.addAttribute("fecha", fechaSql);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    model.addAttribute("fecha", fecha);
	    model.addAttribute("clases", clasesService.mostrarHorasClasesdeunEntrenador(idCategoria, idEntrenador, fechaSql));
	    model.addAttribute("sesion", session.getAttribute("idusuario"));

	    return "usuario/entrenadorDisponibilidad2";
	}

	
	


	@PostMapping("/cart")
	public String addCart(@RequestParam Integer id, Model model, HttpSession session) {
		DetalleOrden detalleOrden = new DetalleOrden();
		Clases clase = new Clases();
		double sumaTotal = 0;

		Optional<Clases> OptionalClase = clasesService.get(id);
		log.info("Producto añadido: {}", OptionalClase.get());
		
		clase = OptionalClase.get();

		
		detalleOrden.setPrecio(clase.getPrecio());
		detalleOrden.setNombre(clase.getNombre());
		detalleOrden.setTotal(clase.getPrecio());
		detalleOrden.setClases(clase);
		clase.setReservado(true);
		clase.setDisponible(true);
		clasesService.save(clase);
		
		//validar que le producto no se añada 2 veces
		Integer idClase=clase.getId();
		boolean ingresado=detalles.stream().anyMatch(p -> p.getClases().getId()==idClase);
		
		if (!ingresado) {
			detalles.add(detalleOrden);
		}
		
		sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();

		orden.setTotal(sumaTotal);
		model.addAttribute("sesion", session.getAttribute("idusuario"));
		model.addAttribute("cart", detalles);
		model.addAttribute("orden", orden);

		return "usuario/carrito";
	}

	// quitar un producto del carrito
	@GetMapping("/delete/cart/{id}")
	public String deleteProductoCart(@PathVariable Integer id, Model model, HttpSession session) {

		// lista nueva de prodcutos
		List<DetalleOrden> ordenesNueva = new ArrayList<DetalleOrden>();

		for (DetalleOrden detalleOrden : detalles) {
			if (detalleOrden.getClases().getId() != id) {
				ordenesNueva.add(detalleOrden);
			}else {
				Clases clase = new Clases();
				Optional<Clases> optionalClase = clasesService.get(id);
				clase = optionalClase.get();
				
				clase.setDisponible(false);
				clase.setReservado(false);
				clasesService.save(clase);
			}
		}

		// poner la nueva lista con los productos restantes
		detalles = ordenesNueva;

		double sumaTotal = 0;
		sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();

		orden.setTotal(sumaTotal);
		model.addAttribute("cart", detalles);
		model.addAttribute("orden", orden);
		model.addAttribute("sesion", session.getAttribute("idusuario"));

		return "usuario/carrito";
	}
	
	@GetMapping("/getCart")
	public String getCart(Model model, HttpSession session) {
		
		model.addAttribute("cart", detalles);
		model.addAttribute("orden", orden);
		
		//sesion
		model.addAttribute("sesion", session.getAttribute("idusuario"));
		return "/usuario/carrito";
	}
	
	@GetMapping("/order")
	public String order(Model model, HttpSession session) {
		Object attribute = session.getAttribute("attributeName");
		if (attribute != null) {
		    String attributeValue = attribute.toString();
		    // Rest of your code
		} else {
		    // Handle the case when the attribute is null
		}

		Usuario usuario =usuarioService.findById( Integer.parseInt(session.getAttribute("idusuario").toString())).get();
		
		model.addAttribute("cart", detalles);
		model.addAttribute("orden", orden);
		model.addAttribute("usuario", usuario);
		
		return "usuario/resumenorden";
	}
	
	// guardar la orden
	@GetMapping("/saveOrder")
	public String saveOrder(HttpSession session ) {
		Date fechaCreacion = new Date();
		orden.setFechaCreacion(fechaCreacion);
		orden.setNumero(ordenService.generarNumeroOrden());
		
		//usuario
		Usuario usuario =usuarioService.findById( Integer.parseInt(session.getAttribute("idusuario").toString())  ).get();
		
		orden.setUsuario(usuario);
		ordenService.save(orden);
		
		//guardar detalles
		for (DetalleOrden dt:detalles) {
			dt.setOrden(orden);
			detalleOrdenService.save(dt);
		}
		
		///limpiar lista y orden
		orden = new Orden();
		detalles.clear();
		
		return "redirect:/";
	}
	
	@PostMapping("/search")
	public String searchProduct(@RequestParam String nombre, Model model) {
		log.info("Nombre del producto: {}", nombre);
		List<Clases> productos= clasesService.findAll().stream().filter( p -> p.getNombre().contains(nombre)).collect(Collectors.toList());
		model.addAttribute("productos", productos);		
		return "usuario/home";
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

}
