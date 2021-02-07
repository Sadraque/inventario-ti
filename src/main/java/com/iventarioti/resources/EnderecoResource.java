package com.iventarioti.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iventarioti.domain.Endereco;
import com.iventarioti.services.EnderecoService;

@RestController
@RequestMapping(value = "/enderecos")
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
		enderecoService.deletar(id);
		
		return ResponseEntity.ok().build();
	}

}
