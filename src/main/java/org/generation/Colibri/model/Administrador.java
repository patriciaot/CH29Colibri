package org.generation.Colibri.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="administrador")
public class Administrador {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name="id", unique=true, nullable=false)
	private Long id;
	@Column(nullable=false)
	private String correo;
	@Column(nullable=false)
	private String contrasena;
	
	public Administrador() {  }

	public Administrador(String correo, String contrasena) {
		this.correo = correo;
		this.contrasena = contrasena;
	}


	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public Long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Administracion [id=" + id + ", correo=" + correo + ", contrasena=" + contrasena + "]";
	}
	
}

