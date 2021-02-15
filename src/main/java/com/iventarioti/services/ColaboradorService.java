package com.iventarioti.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.iventarioti.domain.Colaborador;
import com.iventarioti.repositories.ColaboradorRepository;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	@Autowired
	private EnderecoService enderecoService;

	public Colaborador buscar(Integer id) {
		Optional<Colaborador> obj = colaboradorRepository.findById(id);

		return obj.orElse(null);
	}

	public List<Colaborador> listar() {
		List<Colaborador> obj = colaboradorRepository.findAll();

		return (obj.isEmpty()) ? null : obj;
	}
	
	public void deletar(Integer id) throws EmptyResultDataAccessException {
		Colaborador colaborador = buscar(id);
		
		colaboradorRepository.deleteById(id);
		
		enderecoService.deletar(colaborador.getEndereco().getId());
		
	}
	
	public void deletar(Colaborador colaborador) throws EmptyResultDataAccessException {
		colaboradorRepository.delete(colaborador);

	}
	
	public void adicionar(Colaborador colaborador) {
		colaboradorRepository.saveAll(Arrays.asList(colaborador));
		
	}

}
