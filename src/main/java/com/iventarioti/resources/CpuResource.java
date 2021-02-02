package com.iventarioti.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iventarioti.domain.Cpu;
import com.iventarioti.services.CpuService;
import java.util.List;

@RestController
@RequestMapping(value = "/cpus")
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
		cpuService.deletar(id);
		
		return ResponseEntity.ok().build();
	}
}
