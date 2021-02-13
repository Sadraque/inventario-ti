package com.iventarioti.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iventarioti.domain.Cidade;
import com.iventarioti.services.CidadeService;

@RestController
@RequestMapping(value = "/inventario-ti/cidades")
public class CidadeResource {
	
	@Autowired
	private CidadeService cidadeService;
	
	@RequestMapping(value = "/{id}")
	public ResponseEntity<?> buscar(@PathVariable Integer id) {

		Cidade cidade = cidadeService.buscar(id);

		return (cidade == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(cidade);
	}
	
	@RequestMapping(value = "/all")
	public ResponseEntity<?> listar() {
		List<Cidade> lista = cidadeService.listar();
		
		return (lista == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(lista);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id) {
		try {
			cidadeService.deletar(id);

			return ResponseEntity.ok().build();
		} catch (EmptyResultDataAccessException e) {

			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping(value = "")
	public ResponseEntity<?> adicionar(@RequestBody Cidade cidade) {
		cidadeService.adicionar(cidade);
		
		return ResponseEntity.created(URI.create("/cidades/" +cidade.getId())).body(cidade);
	}

}
