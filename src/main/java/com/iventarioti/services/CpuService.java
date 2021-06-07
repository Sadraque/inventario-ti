/*
package com.iventarioti.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.iventarioti.domain.dto.ColaboradorDTO;
import com.iventarioti.domain.dto.CpuDTO;
import com.iventarioti.domain.dto.find.CpuFindDTO;
import com.iventarioti.domain.dto.save.CpuSaveDTO;
import com.iventarioti.enums.CpuStatus;
import com.iventarioti.util.DateCreator;
import com.iventarioti.util.TypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iventarioti.domain.Cpu;
import com.iventarioti.repositories.CpuRepository;

@Service
public class CpuService {

	@Autowired
	private CpuRepository cpuRepository;

	@Autowired
	private TypeConverter typeConverter;

	@Autowired
	private DateCreator dateCreator;

	@Autowired
	private ColaboradorService colaboradorService;

	public CpuDTO findCpuById(Long id) {
		Optional<Cpu> obj = cpuRepository.findById(id);

		return typeConverter.parseToDTO(obj.get(), CpuDTO.class);
	}
	
	public List<CpuFindDTO> findAll() {
		List<Cpu> obj = cpuRepository.findAll();

		List<CpuFindDTO> cpus = new ArrayList<>();
		obj.forEach(cpu -> {
			CpuFindDTO cpuFindDTO = typeConverter.parseToDTO(cpu, CpuFindDTO.class);

			ColaboradorDTO colaboradorDTO = colaboradorService.buscar(cpu.getColaborador());
			cpuFindDTO.setColaborador(colaboradorDTO);

			cpus.add(cpuFindDTO);
		});

		System.out.println(cpus.size());

		return cpus;
	}
	
	public void delete(Long id) {
		CpuDTO cpu = findCpuById(id);
*/
/*
		if(cpu != null) {
			cpu.setExcluido(true);
			saveOrUpdate(cpu);
		}*//*

	}
	
	public void save(CpuSaveDTO cpu) {
		Cpu cpuEntity = typeConverter.parseToEntity(cpu, Cpu.class);

		if (cpu.getColaborador().equals(null)) {
			cpuEntity.setStatus(CpuStatus.DISPONIVEL);
		} else {
			cpuEntity.setStatus(CpuStatus.EM_USO);
		}

		cpuEntity.setDataCadastro(dateCreator.getDate());
		cpuEntity.setDataAlteracao(cpuEntity.getDataCadastro());

		cpuRepository.save(cpuEntity);
	}

	public void save(CpuDTO cpu) {
		cpuRepository.save(typeConverter.parseToEntity(cpu, Cpu.class));
	}
	
	public void atualizar(Cpu cpu) {
		cpuRepository.saveAll(Arrays.asList(cpu));
		
	}

	private boolean isExcluido(Long id) {
		return findCpuById(id) == null ? true : false;
	}
}
*/
