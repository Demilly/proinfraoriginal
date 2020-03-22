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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ApiProInfra.models.Usuario;
import com.ApiProInfra.repository.UsuarioRepository;

import io.swagger.annotations.ApiOperation;

//import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	UsuarioRepository users;

	@ApiOperation(value = "Retorna uma lista de todos os Usuarios")
	@GetMapping("/usuarios")
	@ResponseStatus
	public List<Usuario> getListUsers() {
		return users.findAll();
	}
	
	@ApiOperation(value = "Retorna unico usuário pelo ID")
	@GetMapping("/usuario/{id}")
	@ResponseStatus
	public Optional<Usuario> getUserbyId(@PathVariable(value = "id") long id) {
		return users.findById(id);
	}

	@ApiOperation(value = "Salva um usuario")
	@PostMapping("/usuario")
	@ResponseStatus
	public Usuario postUser(@RequestBody @Valid Usuario user) {
		return users.save(user);
	}

	@ApiOperation(value = "Deleta usuario")
	@DeleteMapping("/usuario")
	@ResponseStatus
	public void deleteUser(@RequestBody @Valid Usuario user) {
		users.delete(user);
	}
	
	@ApiOperation(value = "Deleta usuario pelo id")
	@DeleteMapping("/usuario/{id}")
	@ResponseStatus
	public void deleteUserId(@PathVariable Long id) {
		users.deleteById(id);
	}
	
	@ApiOperation(value = "Atualiza usuario")
	@PutMapping("/usuario")
	@ResponseStatus
	public Usuario updateUser(@RequestBody @Valid Usuario user) {
		return users.save(user);
	}
	
	@ApiOperation(value = "Atualiza usuario pelo id")
	@PutMapping("/usuario/{id}")
	@ResponseStatus
	public Usuario updateUserId(@PathVariable Long id) {
		return users.save(getUserbyId(id));
	}
	

}

