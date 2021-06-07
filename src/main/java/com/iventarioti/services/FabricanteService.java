package com.iventarioti.services;

import com.iventarioti.domain.Fabricante;
import com.iventarioti.exceptions.InventarioTiBadRequest;
import com.iventarioti.exceptions.InventarioTiNotFoundException;
import com.iventarioti.repositories.FabricanteRepository;
import com.iventarioti.util.DateCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FabricanteService {

	@Autowired
	private FabricanteRepository fabricanteRepository;

	@Autowired
	DateCreator dateCreator;

	public Optional<Fabricante> findById(Long id) {
		validateId(id);

		Optional<Fabricante> fabricante = this.fabricanteRepository.findById(id);

		if(fabricante.isEmpty() || fabricante.equals(null))
			throw new InventarioTiNotFoundException("nenhum registro encontrado");

		return fabricante;
	}

	public List<Fabricante> findAll() {
		List<Fabricante> obj = fabricanteRepository.findAll();

		return obj;
	}

	public void delete(Long id) throws EmptyResultDataAccessException {
		validateId(id);

		try {
			Fabricante fabricante = this.fabricanteRepository.findById(id).get();

			fabricante.setExcluido(true);

			this.fabricanteRepository.save(setDateChange(fabricante));

		} catch (NoSuchElementException e) {
			throw new InventarioTiNotFoundException("Id não existe");
		}
	}

	public void save(Fabricante fabricante) {
		fabricanteRepository.save(setDateChange(setDateRegister(fabricante)));
	}
	
	public void update(Fabricante fabricante) {
		validateId(fabricante.getId());

		if(findById(fabricante.getId()).isEmpty()) {
			throw new InventarioTiNotFoundException("Id não existe");
		}

		fabricanteRepository.save(setDateChange(fabricante));
	}

	private void validateId(Long id) {
		if(id.equals(null) || id == 0)
			throw new InventarioTiBadRequest("Id inválido");
	}

	private Fabricante setDateChange(Fabricante fabricante) {
		fabricante.setDataAlteracao(dateCreator.getDate());

		return fabricante;
	}

	private Fabricante setDateRegister(Fabricante fabricante) {
		fabricante.setDataCadastro(dateCreator.getDate());

		return fabricante;
	}
}
