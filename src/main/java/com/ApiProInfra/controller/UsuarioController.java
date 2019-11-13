package com.ApiProInfra.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ApiProInfra.models.Usuario;
import com.ApiProInfra.repository.UsuarioRepository;

import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	UsuarioRepository users;

	@ApiOperation(value = "Retorna uma lista de Usuarios")
	@GetMapping("/usuarios")
	public List<Usuario> listUsers() {
		return users.findAll();

	}
	
	@ApiOperation(value = "Retorna unico usuário pelo ID")
	@GetMapping("/usuarios/{id}")
	public Optional<Usuario> listUserbyId(@PathVariable(value = "id") long id) {
		return users.findById(id);
	}

	@ApiOperation(value = "Salva um usuario")
	@PostMapping("/usuarios")
	public Usuario postUser(@RequestBody @Valid Usuario user) {
		return users.save(user);
	}

	@ApiOperation(value = "Deleta um usuario")
	@DeleteMapping("/usuarios")
	public void deleteUser(@RequestBody @Valid Usuario user) {
		users.delete(user);
	}

	@ApiOperation(value = "Atualiza um usuario")
	@PutMapping("/usuarios")
	public Usuario updateUser(@RequestBody @Valid Usuario user) {
		return users.save(user);
	}

}

