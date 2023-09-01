package org.generation.Colibri.service;

import java.util.List;

import org.generation.Colibri.model.Administrador;
import org.generation.Colibri.model.ChangeContrasena;
import org.generation.Colibri.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service 
public class AdministradorService {

	private final AdministradorRepository administradorRepository;
	@Autowired
	public AdministradorService(AdministradorRepository administradorRepository) {
		this.administradorRepository = administradorRepository;
	}

	public List<Administrador> getAllAdministrador(){
		return administradorRepository.findAll();
	}
	
	public Administrador getAdministrador(Long id) {
		return administradorRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("Administrador con id " + id +" no existe.")
				);
	}
	public Administrador deleteAdministrador(long id) {
		 Administrador tmp = null;
		 if(administradorRepository.existsById(id)) {
			 tmp=administradorRepository.findById(id).get();
			 administradorRepository.deleteById(id);
		 }//if
		 return tmp;
	 }
	
	 public Administrador addAdministradores(Administrador administrador) {
		 Administrador tmpAdministrador=null;
		 if (administradorRepository.findByCorreo(administrador.getCorreo()).isEmpty()) {
			 tmpAdministrador = administradorRepository.save(administrador);
		 }//if
		 return tmpAdministrador;
	 }
	 
	 public Administrador updateAdministrador(Long id,ChangeContrasena changeContrasena) {
		 Administrador tmp = null;
			 if (administradorRepository.existsById(id)) { 
				 if ( (changeContrasena.getContrasena() !=null) &&
						 (changeContrasena.getContrasena() !=null)) { 
					 tmp = administradorRepository.findById(id).get();
					 System.out.println(tmp);
					 System.out.println(changeContrasena);
					 if(tmp.getContrasena().equals(changeContrasena.getContrasena())) { 
						 tmp.setContrasena(changeContrasena.getNuevaContrasena());
						 administradorRepository.save(tmp);
					 } else {
						 tmp=null;
					 }
				 }
			 }else {
				 System.out.println("Update - el Admon con id " + id + " no existe");
			}
		 return tmp;
	 }
}