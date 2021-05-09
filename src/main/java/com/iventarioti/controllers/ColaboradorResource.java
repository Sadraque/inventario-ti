package com.iventarioti.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iventarioti.domain.Colaborador;
import com.iventarioti.services.ColaboradorService;

@RestController
@RequestMapping(value = "/inventario-ti/colaboradores")
public class ColaboradorResource {

	@Autowired
	private ColaboradorService colaboradorService;

	@RequestMapping(value = "/{id}")
	public ResponseEntity<?> buscar(@PathVariable Long id) {

		Colaborador colaborador = colaboradorService.buscar(id);

		return (colaborador == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(colaborador);
	}

	@RequestMapping(value = "/all")
	public ResponseEntity<?> listar() {
		List<Colaborador> lista = colaboradorService.listar();

		return (lista == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(lista);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		try {
			colaboradorService.deletar(id);

			return ResponseEntity.ok().build();
		} catch (EmptyResultDataAccessException e) {

			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping(value = "")
	public ResponseEntity<?> deletar(@RequestBody Colaborador colaborador) {
		try {
			colaboradorService.deletar(colaborador);

			return ResponseEntity.ok().build();
		} catch (EmptyResultDataAccessException e) {

			return ResponseEntity.notFound().build();
		}

	}
	
	@PostMapping(value = "")
	public ResponseEntity<?> adicionar(@RequestBody Colaborador colaborador) {
		colaboradorService.adicionar(colaborador);
		
		return ResponseEntity.created(URI.create("/colaboradores/" +colaborador.getId())).body(colaborador);
	}
	
	@PutMapping(value = "")
	public ResponseEntity<?> atualizar(@RequestBody Colaborador colaborador) {
		colaboradorService.atualizar(colaborador);
		
		return ResponseEntity.ok().build();
	}
	
}
