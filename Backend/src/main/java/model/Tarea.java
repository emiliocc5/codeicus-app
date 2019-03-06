package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tarea")
public class Tarea {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private int id;
	 
	 @Column(name="nombre")
	 private String nombre;
	 
	 @Column(name="detalle")
	 private String detalle;
	 
	 @Column(name="estado")
	 private String estado;
	 
	 public Tarea (String nom, String det, String est) {
		 nombre=nom;
		 detalle=det;
		 estado=est;
	 }
	 
	 public Tarea() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Tarea [id=" + id + ", nombre=" + nombre + ", detalle=" + detalle + ", estado=" + estado + "]";
	}
	 
	 
	 
	 

}
