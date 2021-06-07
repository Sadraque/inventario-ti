package com.iventarioti.controllers;

import com.iventarioti.domain.Profissao;
import com.iventarioti.domain.dto.ProfissaoDTO;
import com.iventarioti.services.ProfissaoService;
import com.iventarioti.util.TypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/profissoes")
public class ProfissaoController {

	@Autowired
	private ProfissaoService profissaoService;

	@Autowired
	TypeConverter typeConverter;

	@RequestMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Optional<Profissao> obj = profissaoService.findById(id);

		ProfissaoDTO profissao = typeConverter.parseToDTO(obj.get(), ProfissaoDTO.class);

		return (obj.isEmpty()) ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(profissao);
	}

	@RequestMapping(value = "/find-all")
	public ResponseEntity<?> findAll() {
		List<Profissao> profissoes = profissaoService.findAll();

		return (profissoes.isEmpty()) ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(typeConverter.parseToDTO(profissoes, ProfissaoDTO.class));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		profissaoService.delete(id);

		return ResponseEntity.ok().build();
	}
	
    @PostMapping(value = "")
	public ResponseEntity<?> save(@RequestBody ProfissaoDTO profissao) {
		profissaoService.save(typeConverter.parseToEntity(profissao, Profissao.class));
		
		return ResponseEntity.created(URI.create("/profissoes")).build();
	}
	
	@PutMapping(value = "")
	public ResponseEntity<?> update(@RequestBody ProfissaoDTO profissao) {
		profissaoService.update(typeConverter.parseToEntity(profissao, Profissao.class));
		
		return ResponseEntity.ok().build();
	}

}
