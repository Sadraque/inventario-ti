package com.iventarioti.services;

import com.iventarioti.domain.Profissao;
import com.iventarioti.exceptions.InventarioTiBadRequest;
import com.iventarioti.exceptions.InventarioTiNotFoundException;
import com.iventarioti.repositories.ProfissaoRepository;
import com.iventarioti.util.DateCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProfissaoService {

	@Autowired
	private ProfissaoRepository profissaoRepository;

	@Autowired
	DateCreator dateCreator;

	public Optional<Profissao> findById(Long id) {
		validateId(id);

		Optional<Profissao> profissao = this.profissaoRepository.findById(id);

		if(profissao.isEmpty() || profissao.equals(null))
			throw new InventarioTiNotFoundException("nenhum registro encontrado");

		return profissao;
	}

	public List<Profissao> findAll() {
		List<Profissao> obj = profissaoRepository.findAll();

		return obj;
	}

	public void delete(Long id) throws EmptyResultDataAccessException {
		validateId(id);

		try {
			Profissao profissao = this.profissaoRepository.findById(id).get();

			profissao.setExcluido(true);

			this.profissaoRepository.save(setDateChange(profissao));

		} catch (NoSuchElementException e) {
			throw new InventarioTiNotFoundException("Id não existe");
		}
	}

	public void save(Profissao profissao) {
		profissaoRepository.save(setDateChange(setDateRegister(profissao)));
	}
	
	public void update(Profissao profissao) {
		validateId(profissao.getId());

		if(findById(profissao.getId()).isEmpty()) {
			throw new InventarioTiNotFoundException("Id não existe");
		}

		profissaoRepository.save(setDateChange(profissao));
	}

	private void validateId(Long id) {
		if(id.equals(null) || id == 0)
			throw new InventarioTiBadRequest("Id inválido");
	}

	private Profissao setDateChange(Profissao profissao) {
		profissao.setDataAlteracao(dateCreator.getDate());

		return profissao;
	}

	private Profissao setDateRegister(Profissao profissao) {
		profissao.setDataCadastro(dateCreator.getDate());

		return profissao;
	}
}
