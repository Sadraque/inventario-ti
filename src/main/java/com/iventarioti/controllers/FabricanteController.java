package com.iventarioti.controllers;

import com.iventarioti.domain.Fabricante;
import com.iventarioti.domain.dto.FabricanteDTO;
import com.iventarioti.services.FabricanteService;
import com.iventarioti.util.TypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/fabricantes")
public class FabricanteController {

	@Autowired
	private FabricanteService fabricanteService;

	@Autowired
	TypeConverter typeConverter;

	@RequestMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Optional<Fabricante> obj = fabricanteService.findById(id);

		FabricanteDTO fabricante = typeConverter.parseToDTO(obj.get(), FabricanteDTO.class);

		return (obj.isEmpty()) ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(fabricante);
	}

	@RequestMapping(value = "/find-all")
	public ResponseEntity<?> findAll() {
		List<Fabricante> fabricantes = fabricanteService.findAll();

		return (fabricantes.isEmpty()) ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(typeConverter.parseToDTO(fabricantes, FabricanteDTO.class));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		fabricanteService.delete(id);

		return ResponseEntity.ok().build();
	}
	
    @PostMapping(value = "")
	public ResponseEntity<?> save(@RequestBody FabricanteDTO fabricante) {
		fabricanteService.save(typeConverter.parseToEntity(fabricante, Fabricante.class));
		
		return ResponseEntity.created(URI.create("/fabricantes")).build();
	}
	
	@PutMapping(value = "")
	public ResponseEntity<?> update(@RequestBody FabricanteDTO fabricante) {
		fabricanteService.update(typeConverter.parseToEntity(fabricante, Fabricante.class));
		
		return ResponseEntity.ok().build();
	}

}
