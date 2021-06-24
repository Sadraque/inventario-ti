package com.iventarioti.services;

import com.iventarioti.domain.Cpu;
import com.iventarioti.domain.Fabricante;
import com.iventarioti.domain.Colaborador;
import com.iventarioti.domain.Historico;
import com.iventarioti.dto.ColaboradorDTO;
import com.iventarioti.dto.CpuDTO;
import com.iventarioti.dto.CpuSaveDTO;
import com.iventarioti.dto.FabricanteDTO;
import com.iventarioti.enums.CpuStatusEnum;
import com.iventarioti.enums.MotivoHistoricoEnum;
import com.iventarioti.exceptions.InventarioTiBadRequestException;
import com.iventarioti.exceptions.InventarioTiNotFoundException;
import com.iventarioti.repositories.CpuRepository;
import com.iventarioti.repositories.FabricanteRepository;
import com.iventarioti.repositories.ColaboradorRepository;
import com.iventarioti.util.DateCreator;
import com.iventarioti.util.TypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CpuService {

    @Autowired
    private CpuRepository cpuRepository;

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @Autowired
    private DateCreator dateCreator;

    @Autowired
    private HistoricoService historicoService;

    public CpuDTO findById(Long id) {
        Optional<Cpu> cpu = this.cpuRepository.findById(id);

        if(cpu.isEmpty()) {
            throw new InventarioTiNotFoundException("Cpu não encontrada.");
        }

        if(cpu.get().getColaborador() == null) {
            return new CpuDTO(cpu.get());
        }

        return new CpuDTO(cpu.get(), cpu.get().getColaborador());
    }

    public List<CpuDTO> findAll() {
        List<Cpu> list = this.cpuRepository.findAll();

        if(list.isEmpty()) {
            throw new InventarioTiNotFoundException("Nenhuma Cpu encontrada.");
        }

        List<CpuDTO> cpus = new ArrayList<>();

        list.forEach(cpu -> {
            if (cpu.getColaborador() == null) {
                cpus.add(new CpuDTO(cpu));
            } else {
                cpus.add(new CpuDTO(cpu, cpu.getColaborador()));
            }
        });

        return cpus;
    }

    public CpuDTO save(CpuSaveDTO dto) {
        Cpu cpu = new Cpu();
        Historico historico = new Historico();

        Optional<Fabricante> fabricante = this.fabricanteRepository.findById(dto.getFabricante());

        if(fabricante.isEmpty()) {
            throw new InventarioTiBadRequestException("Fabricante não existe. Forneca um Id para uma Fabricante existente");
        }

        if(dto.getColaborador() != null) {
            Optional<Colaborador> colaborador = this.colaboradorRepository.findById(dto.getColaborador());

            if (colaborador.isEmpty()) {
                throw new InventarioTiBadRequestException("Colaborador não existe. Forneca um Id para uma Colaborador existente");
            }

            cpu.setColaborador(colaborador.get());
            cpu.setStatus(CpuStatusEnum.EM_USO);

            historico.setFk_colaborador(colaborador.get().getId());
            historico.setMotivo(MotivoHistoricoEnum.EMPRESTIMO.getMotivoHistorico());

        } else {
            cpu.setStatus(CpuStatusEnum.DISPONIVEL);
            historico.setMotivo(MotivoHistoricoEnum.CADASTRO.getMotivoHistorico());
            historico.setFk_colaborador(2000000L);
        }

        cpu.setAno(dto.getAno());
        cpu.setHdd(dto.getHdd());
        cpu.setSsd(dto.getSsd());
        cpu.setMemoriaRam(dto.getMemoriaRam());
        cpu.setModelo(dto.getModelo());
        cpu.setObservacao(dto.getObservacao());
        cpu.setNumeroSerie(dto.getNumeroSerie());
        cpu.setProcessador(dto.getProcessador());
        cpu.setFabricante(fabricante.get());
        cpu.setDataCadastro(dateCreator.getDate());
        cpu.setDataAlteracao(cpu.getDataCadastro());
        cpu.setExcluido(false);

        cpu = this.cpuRepository.save(cpu);

        historico.setFk_cpu(cpu.getId());
        historico.setDataCadastro(cpu.getDataCadastro());

        this.historicoService.save(historico);

        CpuDTO cpuDTO = TypeConverter.parseToDTO(cpu, CpuDTO.class);
        cpuDTO.setFabricante(TypeConverter.parseToDTO(cpu.getFabricante(), FabricanteDTO.class));

        if(cpu.getColaborador() != null) {
            cpuDTO.setColaborador(TypeConverter.parseToDTO(cpu.getColaborador(), ColaboradorDTO.class));
        }

        return cpuDTO;
    }

    public CpuDTO update(Long id, CpuSaveDTO dto) {
        Optional<Cpu> cpu = this.cpuRepository.findById(id);

        if(cpu.isEmpty()) {
            throw new InventarioTiBadRequestException("Cpu não existe. Forneca um Id para uma Cpu existente");
        }

        Optional<Fabricante> fabricante = this.fabricanteRepository.findById(dto.getFabricante());

        if(fabricante.isEmpty()) {
            throw new InventarioTiBadRequestException("Fabricante não existe. Forneca um Id para uma Fabricante existente");
        }

        Optional<Colaborador> colaborador = this.colaboradorRepository.findById(dto.getColaborador());

        if(dto.getColaborador() != null) {
            if (colaborador.isEmpty()) {
                throw new InventarioTiBadRequestException("Colaborador não existe. Forneca um Id para uma Colaborador existente");
            }

            cpu.get().setColaborador(colaborador.get());
            cpu.get().setStatus(CpuStatusEnum.valueOf(dto.getStatus()));

        }

        cpu.get().setAno(dto.getAno());
        cpu.get().setHdd(dto.getHdd());
        cpu.get().setSsd(dto.getSsd());
        cpu.get().setMemoriaRam(dto.getMemoriaRam());
        cpu.get().setModelo(dto.getModelo());
        cpu.get().setObservacao(dto.getObservacao());
        cpu.get().setNumeroSerie(dto.getNumeroSerie());
        cpu.get().setProcessador(dto.getProcessador());
        cpu.get().setFabricante(fabricante.get());
        cpu.get().setDataAlteracao(dateCreator.getDate());

        this.cpuRepository.save(cpu.get());

        return new CpuDTO(cpu.get());
    }

    public void delete(Long id) {
        Optional<Cpu> cpu = this.cpuRepository.findById(id);

        if(cpu.isEmpty()) {
            throw new InventarioTiNotFoundException("Cpu não encontrada.");
        }

        cpu.get().setExcluido(true);

        this.cpuRepository.save(setChangeDate(cpu.get()));
    }

    private Cpu setChangeDate(Cpu cpu) {
        cpu.setDataAlteracao(dateCreator.getDate());

        return cpu;
    }
}
