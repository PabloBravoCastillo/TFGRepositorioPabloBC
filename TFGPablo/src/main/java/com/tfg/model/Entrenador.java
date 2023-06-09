package com.tfg.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Entrenador")
public class Entrenador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String descripcion;
	private String ubicacion;
	private String imagen;
	private boolean desactivado;
	
	@OneToOne
	private Usuario usuario;
	
	@OneToMany(mappedBy = "entrenador")
	private List<Modalidad> modalidades;
	
	@OneToMany(mappedBy = "entrenador")
	private List<Clases> clases;

	public Entrenador() {
		
	}

	public Entrenador(Integer id, String nombre, String descripcion, String ubicacion, String imagen,
			boolean activado, Usuario usuario, List<Modalidad> modalidades, List<Clases> clases) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.ubicacion = ubicacion;
		this.imagen = imagen;
		this.desactivado = activado;
		this.usuario = usuario;
		this.modalidades = modalidades;
		this.clases = clases;
	}

	// Getters y setters
	
	@Override
	public String toString() {
		return "Entrenador [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", ubicacion="
				+ ubicacion + ", imagen=" + imagen + ", desactivado=" + desactivado + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public boolean isDesactivado() {
		return desactivado;
	}

	public void setDesactivado(boolean desactivado) {
		this.desactivado = desactivado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Modalidad> getModalidades() {
		return modalidades;
	}

	public void setModalidades(List<Modalidad> modalidades) {
		this.modalidades = modalidades;
	}

	public List<Clases> getClases() {
		return clases;
	}

	public void setClases(List<Clases> clases) {
		this.clases = clases;
	}
}
