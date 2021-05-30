package com.iventarioti.controllers;

import java.net.URI;
import java.util.List;

import com.iventarioti.domain.dto.CidadeDTO;
import com.iventarioti.domain.dto.save.CidadeSaveDTO;
import com.iventarioti.exceptions.InventarioTiNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.iventarioti.services.CidadeService;

@RestController
@RequestMapping(value = "/inventario-ti/cidades")
public class CidadeResource {
	
	@Autowired
	private CidadeService cidadeService;
	
	@RequestMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) throws InventarioTiNotFoundException {

		CidadeDTO cidade = cidadeService.findById(id);

		return (cidade == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(cidade);
	}
	
	@RequestMapping(value = "/find-all")
	public ResponseEntity<?> findAll() throws InventarioTiNotFoundException {
		List<CidadeDTO> cidades = cidadeService.findAll();
		
		return (cidades == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(cidades);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		try {
			cidadeService.delete(id);

			return ResponseEntity.ok().build();
		} catch (EmptyResultDataAccessException e) {

			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping(value = "")
	public ResponseEntity<?> save(@RequestBody CidadeSaveDTO cidade) {
		cidadeService.save(cidade);
		
		return ResponseEntity.created(URI.create("/cpus/")).body(cidade);
	}
	
	@PutMapping(value = "")
	public ResponseEntity<?> update(@RequestBody CidadeDTO cidade) throws InventarioTiNotFoundException {
		cidadeService.update(cidade);
		
		return ResponseEntity.ok().build();
	}

}
