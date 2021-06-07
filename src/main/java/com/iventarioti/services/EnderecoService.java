package com.iventarioti.services;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.iventarioti.exceptions.InventarioTiBadRequest;
import com.iventarioti.exceptions.InventarioTiNotFoundException;
import com.iventarioti.util.DateCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.iventarioti.domain.Endereco;
import com.iventarioti.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	DateCreator dateCreator;

	public Optional<Endereco> findById(Long id) {
		validateId(id);

		Optional<Endereco> endereco = this.enderecoRepository.findById(id);

		if(endereco.isEmpty() || endereco.equals(null))
			throw new InventarioTiNotFoundException("nenhum registro encontrado");

		return endereco;
	}

	public List<Endereco> findAll() {
		List<Endereco> obj = enderecoRepository.findAll();

		return obj;
	}

	public void delete(Long id) throws EmptyResultDataAccessException {
		validateId(id);

		try {
			Endereco endereco = this.enderecoRepository.findById(id).get();

			endereco.setExcluido(true);

			this.enderecoRepository.save(setDateChange(endereco));

		} catch (NoSuchElementException e) {
			throw new InventarioTiNotFoundException("Id não existe");
		}
	}

	public void save(Endereco endereco) {
		enderecoRepository.save(setDateChange(setDateRegister(endereco)));
	}
	
	public void update(Endereco endereco) {
		validateId(endereco.getId());

		if(findById(endereco.getId()).isEmpty()) {
			throw new InventarioTiNotFoundException("Id não existe");
		}

		enderecoRepository.save(setDateChange(endereco));
	}

	private void validateId(Long id) {
		if(id.equals(null) || id == 0)
			throw new InventarioTiBadRequest("Id inválido");
	}

	private Endereco setDateChange(Endereco endereco) {
		endereco.setDataAlteracao(dateCreator.getDate());

		return endereco;
	}

	private Endereco setDateRegister(Endereco endereco) {
		endereco.setDataCadastro(dateCreator.getDate());

		return endereco;
	}
}
