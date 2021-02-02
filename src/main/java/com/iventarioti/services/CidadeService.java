package com.iventarioti.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

}
