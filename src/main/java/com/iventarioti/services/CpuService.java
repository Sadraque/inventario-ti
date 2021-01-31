package com.iventarioti.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iventarioti.domain.Cpu;
import com.iventarioti.repositories.CpuRepository;

@Service
public class CpuService {

	@Autowired
	private CpuRepository cpuRepository;

	public Cpu buscar(Integer id) {
		Optional<Cpu> obj = cpuRepository.findById(id);

		return obj.orElseThrow();
	}
	
	public List<Cpu> listar() {
		List<Cpu> obj = cpuRepository.findAll();

		return obj;
	}
}
