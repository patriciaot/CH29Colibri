package org.generation.Colibri.controller;

import java.util.List;

import org.generation.Colibri.model.Administrador;
import org.generation.Colibri.model.ChangeContrasena;
import org.generation.Colibri.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


	@RestController
	//@CrossOrigin(origins="*", methods{RequestMethod.GET, RequestMethod.POST})
	@RequestMapping (path = "/administrador/") // http://localhost:8080/administrador/
	public class AdministradorController {

		private final AdministradorService administradorService;
		
		@Autowired 
		public  AdministradorController(AdministradorService administradorService) {
			this.administradorService = administradorService;
		}
		
		@GetMapping
		public List<Administrador> getAdministrador(){
			return administradorService.getAllAdministrador();
		}
		
		@GetMapping (path="{admiId}") 
		public Administrador getAdministrador(@PathVariable("admiId") Long id) {
			return administradorService.getAdministrador(id);
		}
		
		@PutMapping  (path="{admiId}") 
		public Administrador updateAdministrador (@PathVariable("admiId") Long id,
				@RequestBody ChangeContrasena changeContrasena){
			return administradorService.updateAdministrador(id, changeContrasena);
		}

		@DeleteMapping (path="{admiId}")  
		public Administrador deleteAdministrador(@PathVariable("admiId") Long id) {
			return administradorService.deleteAdministrador(id);
		}
		
		@PostMapping 
		public Administrador addAdministrador (@RequestBody Administrador administrador) {
			return administradorService.addAdministradores(administrador);
		}
	}//classadmincontroller
