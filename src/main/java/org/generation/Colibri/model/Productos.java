package org.generation.Colibri.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "productos")
public class Productos {
	//POJO 
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY) //primaryKey
	@Column (name= "id", unique=true, nullable=false)//las anotaciones solo afectan a la siguiente linea de codigo que tenemos es decir estas 3 afectan a Long Id 
	private Long id;
	@Column(nullable=false)
	private String name;
	private String descripcion;
	private Double precio;
	private Integer cantidad;
	private String categoria; 
	@Column(nullable=false)
	private String img;

	
public Productos( String name, String descripcion, Double precio, Integer cantidad, String categoria,
		String img) {
	
	this.name = name;
	this.descripcion = descripcion;
	this.precio = precio;
	this.cantidad = cantidad;
	this.categoria = categoria;
	this.img = img;

}//constructor

	public Productos() { }//constructor vacío
	
	
	public String getName() {
		return name;
	}//getNombre
	
	public void setNombre(String name) {
		this.name = name;
	}//setNombre
	
	public String getDescripcion() {
		return descripcion;
	}//getDescripcion
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}//SetDescripcion
	
	public Double getPrecio() {
		return precio;
	}//getPrecio
	
	public void setPrecio(Double precio) {
		this.precio = precio;
	}//setPrecio
	
	public Integer getCantidad() {
		return cantidad;
	}//getCantidad
	
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}//setCantidad
	
	public String getCategoria() {
		return categoria;
	}//getCategoria
	
	public void setCategoria(String categoria) {
	 this.categoria=categoria;
	}//setCategoria
	
	public String getImg() {
		return img;
	}//getImage
	
	public void setImagen(String img) {
		this.img = img;
	}//setImage
	
	
	@Override
	public String toString() {
		return "Productos [id=" + id + ", name=" + name + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", cantidad=" + cantidad + ", categoria=" + categoria + ", img=" + img + "]";
	}//to String
	
	
	public Long getId() {
		return id;
	}//getId

}//Clase Productos

