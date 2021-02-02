package com.iventarioti.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iventarioti.domain.Colaborador;
import com.iventarioti.services.ColaboradorService;

@RestController
@RequestMapping(value = "/colaboradores")
public class ColaboradorResource {

	@Autowired
	private ColaboradorService colaboradorService;

	@RequestMapping(value = "/{id}")
	public ResponseEntity<?> buscar(@PathVariable Integer id) {

		Colaborador colaborador = colaboradorService.buscar(id);

		return (colaborador == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(colaborador);
	}

	@RequestMapping(value = "/all")
	public ResponseEntity<?> listar() {
		List<Colaborador> lista = colaboradorService.listar();

		return (lista == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(lista);
	}
}
