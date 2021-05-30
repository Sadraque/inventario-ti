package com.iventarioti.controllers;

import com.iventarioti.domain.dto.CpuDTO;
import com.iventarioti.domain.dto.find.CpuFindDTO;
import com.iventarioti.domain.dto.save.CpuSaveDTO;
import com.iventarioti.util.TypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.iventarioti.domain.Cpu;
import com.iventarioti.services.CpuService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/inventario-ti/cpus")
public class CpuResource {

	@Autowired
	private CpuService cpuService;

	@Autowired
	private TypeConverter typeConverter;

	@RequestMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Long id) {

		CpuDTO cpu = cpuService.findCpuById(id);

		return (cpu == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(cpu);
	}
	
	@RequestMapping(value = "/all")
	public ResponseEntity<?> listar() {
		List<CpuFindDTO> lista = cpuService.findAll();
		
		return (lista == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(lista);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		try {
			cpuService.delete(id);

			return ResponseEntity.ok().build();
		} catch (EmptyResultDataAccessException e) {

			return ResponseEntity.notFound().build();
		}
	}
	
/*	@DeleteMapping(value = "")
	public ResponseEntity<?> deletar(@RequestBody Cpu cpu) {
		try {
			cpuService.deletar(cpu);

			return ResponseEntity.ok().build();
		} catch (EmptyResultDataAccessException e) {

			return ResponseEntity.notFound().build();
		}

	}*/
	
    @PostMapping(value = "")
	public ResponseEntity<?> adicionar(@RequestBody CpuSaveDTO cpu) {
		cpuService.save(cpu);
		
		return ResponseEntity.created(URI.create("/cpus/")).body(cpu);
	}
	
	@PutMapping(value = "")
	public ResponseEntity<?> atualizar(@RequestBody Cpu cpu) {
		cpuService.atualizar(cpu);
		
		return ResponseEntity.ok().build();
	}
}
