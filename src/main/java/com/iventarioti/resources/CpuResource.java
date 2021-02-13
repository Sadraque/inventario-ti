package com.iventarioti.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iventarioti.domain.Cpu;
import com.iventarioti.services.CpuService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/inventario-ti/cpus")
public class CpuResource {

	@Autowired
	private CpuService cpuService;

	@RequestMapping(value = "/{id}")
	public ResponseEntity<?> buscar(@PathVariable Integer id) {

		Cpu cpu = cpuService.buscar(id);

		return (cpu == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(cpu);
	}
	
	@RequestMapping(value = "/all")
	public ResponseEntity<?> listar() {
		List<Cpu> lista = cpuService.listar();
		
		return (lista == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(lista);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id) {
		try {
			cpuService.deletar(id);

			return ResponseEntity.ok().build();
		} catch (EmptyResultDataAccessException e) {

			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping(value = "")
	public ResponseEntity<?> adicionar(@RequestBody Cpu cpu) {
		cpuService.adicionar(cpu);
		
		return ResponseEntity.created(URI.create("/cpus/" +cpu.getId())).body(cpu);
	}
}
