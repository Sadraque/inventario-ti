package com.iventarioti.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iventarioti.domain.Colaborador;
import com.iventarioti.repositories.ColaboradorRepository;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository colaboradorRepository;

	public Colaborador buscar(Integer id) {
		Optional<Colaborador> obj = colaboradorRepository.findById(id);

		return obj.orElse(null);
	}

	public List<Colaborador> listar() {
		List<Colaborador> obj = colaboradorRepository.findAll();

		return (obj.isEmpty()) ? null : obj;
	}

}
