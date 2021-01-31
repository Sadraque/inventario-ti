package com.iventarioti.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iventarioti.domain.Cpu;
import com.iventarioti.services.CpuService;

@RestController
@RequestMapping(value = "/cpus")
public class CpuResource {

	@Autowired
	private CpuService cpuService;

	@RequestMapping(value = "/{id}")
	public ResponseEntity<?> buscar(@PathVariable Integer id) {

		Cpu cpu = cpuService.buscar(id);

		return ResponseEntity.ok().body(cpu);
	}
}
