package org.generation.Colibri.controller;

import java.util.List;

import org.generation.Colibri.model.Productos;
import org.generation.Colibri.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/productos/") // http://localhost:8080/productos/

public class ProductosController {

	private final ProductosService productosService;
	
	@Autowired
	public ProductosController(ProductosService productosService) {
		this.productosService = productosService;
	}//constructor
	
	@GetMapping
	public List <Productos> getAllProductos(){
		return productosService.getAllProductos();
	}//getAllProductos
	
	@GetMapping(path = "{prodId}")
	public Productos getProduct(@PathVariable ("prodId") Long id){
		return productosService.getProductos(id);	
		}//getProductos
	
	@DeleteMapping(path = "{prodId}")
	public Productos deleteProduct(@PathVariable ("prodId") Long id){
		return productosService.deleteProductos(id);		
	}//deleteProduct
	
	@PostMapping
	public Productos addProduct (@RequestBody Productos productos) {
		return productosService.addProductos(productos);
	}//addProduct
	
	@PutMapping(path="{prodId}")
	public Productos updateProduct(@PathVariable("prodId") Long id,
			@RequestParam(required=false) String name,
			@RequestParam(required=false)  String descripcion,
			@RequestParam(required=false)  Double precio,
			@RequestParam(required=false)  Integer cantidad,
			@RequestParam(required=false)  String categoria,
			@RequestParam(required=false)  String img) {
		return productosService.updateProductos(id, name, descripcion, precio, cantidad, categoria, img);
	}//updateProduct
	
	
}//Class ProductosController
