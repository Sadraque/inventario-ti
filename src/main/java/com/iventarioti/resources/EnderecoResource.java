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

import com.iventarioti.domain.Endereco;
import com.iventarioti.services.EnderecoService;

@RestController
@RequestMapping(value = "/inventario-ti/enderecos")
public class EnderecoResource {

	@Autowired
	private EnderecoService enderecoService;

	@RequestMapping(value = "/{id}")
	public ResponseEntity<?> buscar(@PathVariable Integer id) {

		Endereco endereco = enderecoService.buscar(id);

		return (endereco == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(endereco);
	}

	@RequestMapping(value = "/all")
	public ResponseEntity<?> listar() {
		List<Endereco> lista = enderecoService.listar();

		return (lista == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(lista);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id) {
		try {
			enderecoService.deletar(id);

			return ResponseEntity.ok().build();
		} catch (EmptyResultDataAccessException e) {

			return ResponseEntity.notFound().build();
		}

	}
	
	@PostMapping(value = "")
	public ResponseEntity<?> adicionar(@RequestBody Endereco endereco) {
		enderecoService.adicionar(endereco);
		
		return ResponseEntity.created(URI.create("/enderecos/" +endereco.getId())).body(endereco);
	}

}
