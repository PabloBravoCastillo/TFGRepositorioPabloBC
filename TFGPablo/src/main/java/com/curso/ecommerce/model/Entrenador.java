package com.curso.ecommerce.model;

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
		
		@OneToOne
		private Usuario usuario;
		
		@OneToMany(mappedBy = "entrenador")
		private List<Modalidad> modalidades;
		
		@OneToMany(mappedBy = "entrenador")
		private List<Clases> clases;
	
		
		
		public Entrenador() {
			
		}

		public Entrenador(Integer id, String nombre, String descripcion, String ubicacion, String imagen,
				Usuario usuario, List<Modalidad> modalidades, List<Clases> clases) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.descripcion = descripcion;
			this.ubicacion = ubicacion;
			this.imagen = imagen;
			this.usuario = usuario;
			this.modalidades = modalidades;
			this.clases = clases;
		}


		public String getDescripcion() {
			return descripcion;
		}


		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}


		public List<Modalidad> getModalidades() {
			return modalidades;
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


		public Usuario getUsuario() {
			return usuario;
		}


		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}


		public List<Clases> getClases() {
			return clases;
		}


		public void setClases(List<Clases> clases) {
			this.clases = clases;
		}


		public void setModalidades(List<Modalidad> modalidades) {
			this.modalidades = modalidades;
		}


		@Override
		public String toString() {
			return "Entrenador [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", ubicacion="
					+ ubicacion + ", imagen=" + imagen + ", usuario=" + usuario + ", modalidades=" + modalidades
					+ ", clases=" + clases + "]";
		}



		
}
