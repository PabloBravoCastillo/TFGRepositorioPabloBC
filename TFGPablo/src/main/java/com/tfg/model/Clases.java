package com.tfg.model;

import java.sql.Time;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clases")
public class Clases {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String descripcion;
	private String imagen;
	private String horaInicio;
	private String horaFin;
	private double precio;
	private boolean reservado;
	private boolean disponible;
	private boolean confirmado;
	
	@ManyToOne
	@JoinColumn(name = "modalidad_id")
	private Modalidad modalidad;
	
	@ManyToOne
	@JoinColumn(name = "entrenador_id")
	private Entrenador entrenador;

	public Clases() {
		
	}

	public Clases(Integer id, String nombre, String descripcion, String imagen, String horaInicio, String horaFin,
			double precio, boolean reservado, boolean disponible, boolean confirmado, Modalidad modalidad,
			Entrenador entrenador) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.precio = precio;
		this.reservado = reservado;
		this.disponible = disponible;
		this.confirmado = confirmado;
		this.modalidad = modalidad;
		this.entrenador = entrenador;
	}

	// Getters y setters

	@Override
	public String toString() {
		return "Clases [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", imagen=" + imagen
				+ ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", precio=" + precio + ", reservado="
				+ reservado + ", disponible=" + disponible + ", confirmado=" + confirmado + "]";
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isReservado() {
		return reservado;
	}

	public void setReservado(boolean reservado) {
		this.reservado = reservado;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public boolean isConfirmado() {
		return confirmado;
	}

	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}

	public Modalidad getModalidad() {
		return modalidad;
	}

	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}
}

