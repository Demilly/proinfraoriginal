package com.ApiProInfra.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ApiProInfra.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario save(Optional<Usuario> userbyId);


}

