package com.iventarioti.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.iventarioti.domain.dto.EnderecoDTO;
import com.iventarioti.util.TypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.iventarioti.domain.Endereco;
import com.iventarioti.services.EnderecoService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	TypeConverter typeConverter;

	@RequestMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Optional<Endereco> obj = enderecoService.findById(id);

		EnderecoDTO endereco = typeConverter.parseToDTO(obj.get(), EnderecoDTO.class);

		return (obj.isEmpty()) ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(endereco);
	}

	@RequestMapping(value = "/find-all")
	public ResponseEntity<?> findAll() {
		List<Endereco> enderecos = enderecoService.findAll();

		return (enderecos.isEmpty()) ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(typeConverter.parseToDTO(enderecos, EnderecoDTO.class));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		enderecoService.delete(id);

		return ResponseEntity.ok().build();
	}
	
    @PostMapping(value = "")
	public ResponseEntity<?> save(@RequestBody EnderecoDTO endereco) {
		enderecoService.save(typeConverter.parseToEntity(endereco, Endereco.class));
		
		return ResponseEntity.created(URI.create("/enderecos")).build();
	}
	
	@PutMapping(value = "")
	public ResponseEntity<?> update(@RequestBody EnderecoDTO endereco) {
		enderecoService.update(typeConverter.parseToEntity(endereco, Endereco.class));
		
		return ResponseEntity.ok().build();
	}

}
