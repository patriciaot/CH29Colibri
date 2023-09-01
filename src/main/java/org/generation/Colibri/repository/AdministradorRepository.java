package org.generation.Colibri.repository;


import java.util.Optional;

import org.generation.Colibri.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long>{
	
	Optional<Administrador> findByCorreo (String correo);   
	
	}//interface ProductoRepository{

