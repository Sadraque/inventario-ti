package com.iventarioti.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.iventarioti.domain.Endereco;
import com.iventarioti.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	public Endereco buscar(Integer id) {
		Optional<Endereco> obj = enderecoRepository.findById(id);

		return obj.orElse(null);
	}

	public List<Endereco> listar() {
		List<Endereco> obj = enderecoRepository.findAll();

		return (obj.isEmpty()) ? null : obj;
	}

	public void deletar(Integer id) throws EmptyResultDataAccessException {
		enderecoRepository.deleteById(id);

	}
	
	public void adicionar(Endereco endereco) {
		enderecoRepository.saveAll(Arrays.asList(endereco));
		
	}

}
