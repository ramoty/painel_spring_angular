package com.admin.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.admin.demo.model.Usuario;
import com.admin.demo.repository.UsuarioRepository;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioRepository repository;

	@GetMapping("/usuarios")
	public List<Usuario> buscarTodos() {
		return repository.findAll();
	}

	@PostMapping("/usuarios")
	public Usuario cadastrar(@RequestParam Usuario usuario) {
		return repository.save(usuario);
	}

	@PutMapping("/usuarios")
	public Usuario atualizar(@RequestParam Usuario usuario) {
		return repository.save(usuario);
	}

	@DeleteMapping("/usuarios")
	public void remover(@RequestParam Usuario usuario) {
		repository.delete(usuario);
	}

	@DeleteMapping("/usuarios/:id")
	public void remover(@PathParam(value = "id") Integer id) {
		repository.delete(id);
	}

}
