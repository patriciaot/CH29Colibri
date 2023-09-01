package org.generation.Colibri.model;

public class ChangeContrasena {
	private String contrasena;
	private String nuevaContrasena;
	public ChangeContrasena() { } //constructor
	public ChangeContrasena(String contrasena, String nuevaContrasena) {
		super();
		this.contrasena = contrasena;
		this.nuevaContrasena = nuevaContrasena;
	}//constructor

	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getNuevaContrasena() {
		return nuevaContrasena;
	}
	public void setNuevaContrasena(String nuevaContrasena) {
		this.nuevaContrasena = nuevaContrasena;
	}
	@Override
	public String toString() {
		return "ChangeContrasena [contrasena=" + contrasena + ", nuevaContrasena=" + nuevaContrasena + "]";
		
	}//toString	
}//ChangeContrasena
