package org.generation.Colibri.service;

import java.util.List;

import org.generation.Colibri.model.ChangeContrasena;
import org.generation.Colibri.model.Usuarios;
import org.generation.Colibri.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService {

    private final UsuariosRepository usuariosRepository;

    @Autowired
    public UsuariosService(UsuariosRepository usuariosRepository) {
    	this.usuariosRepository = usuariosRepository;
    }//constructor

	public List<Usuarios> getAllUsuarios() {
		return usuariosRepository.findAll();
	}//getAllUsuarios

	public Usuarios getUsuarios(Long id) {
	return usuariosRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("Usuario con id " + id + " no existe.")
				);
	}//getUsuarios

	public Usuarios deleteUsuarios(Long id) {
		Usuarios tmp = null;
    	if (usuariosRepository.existsById(id)) {
    		tmp = usuariosRepository.findById(id).get();
			usuariosRepository.deleteById(id);
		}//if
		return tmp;
	}//deleteUsuarios

	public Usuarios addUsuarios(Usuarios usuarios) {
		Usuarios tmp=null;
		if(usuariosRepository.findByCorreo(usuarios.getCorreo()).isEmpty()) {
		tmp = usuariosRepository.save(usuarios);
		} else {
			System.out.println("El usuario con el correo ["
					+ usuarios.getCorreo() + "] ya está registrado");
		}
		return tmp;
	}//addUsuarios

	public Usuarios updateUsuarios (Long id, ChangeContrasena changeContrasena) {
		Usuarios tmp = null; 
		if(usuariosRepository.existsById(id)) {
			tmp=usuariosRepository.findById(id).get();
			if (changeContrasena.getContrasena()!=null && changeContrasena.getNuevaContrasena()!=null) {
				if (tmp.getContrasena().equals(changeContrasena.getContrasena())) {
					tmp.setContrasena(changeContrasena.getNuevaContrasena()); 
					usuariosRepository.save(tmp);				
				} else {
					tmp = null;		
				}//else //if password			
			}//if !=null			
		} else {
			System.out.println("Update - El usuario con el id ["
					+ id +"] no existe");			
		}//else //if
		return tmp;
	}//updateUsuario
	

}//UsuariosService
