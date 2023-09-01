package org.generation.Colibri.controller;

import java.util.List;

import org.generation.Colibri.model.ChangeContrasena;
import org.generation.Colibri.model.Usuarios;
import org.generation.Colibri.service.UsuariosService;

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
@RequestMapping (path="/login/") // http://localhost:8080/login

public class UsuariosController {
	
		private final UsuariosService usuariosService;

		@Autowired
		public UsuariosController(UsuariosService usuariosServices) {
			this.usuariosService = usuariosServices;
		}//constructor
		
		@GetMapping
		public List<Usuarios> GetAllUsuarios(){
			return usuariosService.getAllUsuarios();
		}//getAllUsers
		
		@GetMapping(path="{userId}")
		public Usuarios getUsuarios(@PathVariable("userId") Long id) {
			return usuariosService.getUsuarios(id);
		}//getUser
		
		@DeleteMapping(path="{userId}")
		public Usuarios deleteUsuarios(@PathVariable("userId") Long id) {
			return usuariosService.deleteUsuarios(id);
		}//deleteUser
		
		@PostMapping
		public Usuarios addUsuarios(@RequestBody Usuarios usuarios) {
			return usuariosService.addUsuarios(usuarios);
		}//addUser
		
		//   DTO  DATA Transfer Object	
		@PutMapping(path="{userId}")
		public Usuarios updateUsuarios(@PathVariable("userId") Long id,
				@RequestBody ChangeContrasena changeContrasena) {
			return usuariosService.updateUsuarios(id, changeContrasena);
		}//updateUser
		
	
	
}//UsuariosController
