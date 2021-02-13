package com.iventarioti.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.iventarioti.domain.Cidade;
import com.iventarioti.repositories.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public Cidade buscar(Integer id) {
		Optional<Cidade> obj = cidadeRepository.findById(id);

		return obj.orElse(null);
	}
	
	public List<Cidade> listar() {
		List<Cidade> obj = cidadeRepository.findAll();

		return (obj.isEmpty()) ? null : obj;
	}
	
	public void deletar(Integer id) throws EmptyResultDataAccessException {
		
		cidadeRepository.deleteById(id);
	}
	
	public void adicionar(Cidade cidade) {
		cidadeRepository.saveAll(Arrays.asList(cidade));
		
	}

}
