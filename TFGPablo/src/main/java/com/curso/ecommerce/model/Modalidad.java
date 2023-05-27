package com.curso.ecommerce.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Modalidad")
public class Modalidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String disponibilidad;
	private String imagen;
	private Date date;
	private String ubicacion;
	private String modalidad;
	private Integer duracion;
	private Integer intervaloentreclases;

	  @ManyToOne
	    @JoinColumn(name = "entrenador_id")
	    private Entrenador entrenador;
	  
	  @OneToMany(mappedBy = "modalidad")
	  private List<Clases> clases;
	  
	@OneToOne
	private Categoria categoria;

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

	public String getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}

	public List<Clases> getClases() {
		return clases;
	}

	public void setClases(List<Clases> clases) {
		this.clases = clases;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public Integer getIntervaloentreclases() {
		return intervaloentreclases;
	}

	public void setIntervaloentreclases(Integer intervaloentreclases) {
		this.intervaloentreclases = intervaloentreclases;
	}

	@Override
	public String toString() {
		return "Modalidad [id=" + id + ", nombre=" + nombre + ", disponibilidad=" + disponibilidad + ", imagen="
				+ imagen + ", date=" + date + ", ubicacion=" + ubicacion + ", modalidad=" + modalidad + ", duracion="
				+ duracion + ", intervaloentreclases=" + intervaloentreclases + ", entrenador=" + entrenador
				+ ", clases=" + clases + ", categoria=" + categoria + "]";
	}


	
	
	
}

