package com.iventarioti.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.iventarioti.domain.dto.CidadeDTO;
import com.iventarioti.domain.dto.save.CidadeSaveDTO;
import com.iventarioti.exceptions.InventarioTiBadRequest;
import com.iventarioti.exceptions.InventarioTiNotFoundException;
import com.iventarioti.util.TypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.iventarioti.domain.Cidade;
import com.iventarioti.repositories.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private TypeConverter typeConverter;
	
	public CidadeDTO findById(Long id) throws InventarioTiNotFoundException {
		Optional<Cidade> obj = cidadeRepository.findById(id);

		if (obj.isEmpty()) {
			throw new InventarioTiNotFoundException("Não foi encontrada uma Cidade com o id fornecido");
		}

		return typeConverter.parseToDTO(obj.get(), CidadeDTO.class);
	}
	
	public List<CidadeDTO> findAll() throws InventarioTiNotFoundException {
		List<Cidade> obj = cidadeRepository.findAll();

		if(obj.isEmpty()) {
			throw new InventarioTiNotFoundException("Não foi encontrada nenhuma Cidade");
		}

		List<CidadeDTO> cidades = new ArrayList<>();

		obj.forEach(cidade -> {
			cidades.add(typeConverter.parseToDTO(cidade, CidadeDTO.class));
		});

		return cidades;
	}
	
	public void delete(Long id) throws InventarioTiBadRequest {
		try {
			cidadeRepository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new InventarioTiBadRequest("Impossivel deletar Cidade com id inexistente. Informe um id válido!");
		}
	}

	public void save(CidadeSaveDTO cidade) {
		cidadeRepository.save(typeConverter.parseToEntity(cidade, Cidade.class));
	}
	
	public void update(CidadeDTO cidade) throws InventarioTiNotFoundException{
		if(cidadeRepository.findById(cidade.getId()).isEmpty()) {
			throw new InventarioTiBadRequest("Impossivel alterar uma Cidade com id inexistente. Informe uma Cidade com id válido!");
		}

		cidadeRepository.save(typeConverter.parseToEntity(cidade, Cidade.class));
	}

}
