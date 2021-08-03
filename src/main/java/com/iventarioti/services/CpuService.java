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
import com.iventarioti.util.DateUtils;
import com.iventarioti.util.TypeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CpuService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CpuRepository cpuRepository;

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @Autowired
    private HistoricoService historicoService;

    private Long ID_COLABORADOR_SISTEMA = 2000000L;

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
        Colaborador cpuColaborador = null;
        CpuStatusEnum cpuStatus = CpuStatusEnum.DISPONIVEL;
        MotivoHistoricoEnum motivoHistorico = MotivoHistoricoEnum.CADASTRO;
        Long idColaboradorHistorico = this.ID_COLABORADOR_SISTEMA;

        Optional<Fabricante> fabricante = this.fabricanteRepository.findById(dto.getFabricante());

        if(fabricante.isEmpty()) {
            throw new InventarioTiBadRequestException("Fabricante não existe. Forneca um Id para uma Fabricante existente");
        }

        if(dto.getColaborador() != null) {
            Optional<Colaborador> colaborador = this.colaboradorRepository.findById(dto.getColaborador());

            if (colaborador.isEmpty()) {
                throw new InventarioTiBadRequestException("Colaborador não existe. Forneca um Id para uma Colaborador existente");
            }

            cpuColaborador = colaborador.get();
            cpuStatus = CpuStatusEnum.EM_USO;
            idColaboradorHistorico = colaborador.get().getId();
            motivoHistorico = MotivoHistoricoEnum.EMPRESTIMO;
        }

        Date dateNow = DateUtils.getCurrentDate();

        Cpu cpu = Cpu.builder()
                .ano(dto.getAno())
                .hdd(dto.getHdd())
                .ssd(dto.getSsd())
                .memoriaRam(dto.getMemoriaRam())
                .modelo(dto.getModelo())
                .observacao(dto.getObservacao())
                .numeroSerie(dto.getNumeroSerie())
                .processador(dto.getProcessador())
                .fabricante(fabricante.get())
                .dataCadastro(dateNow)
                .dataAlteracao(dateNow)
                .status(cpuStatus)
                .colaborador(cpuColaborador)
                .excluido(false)
                .build();

        cpu = this.cpuRepository.save(cpu);
        entityManager.detach(cpu);

        Historico historico = Historico.builder()
                .fkCpu(cpu.getId())
                .fkColaborador(idColaboradorHistorico)
                .dataCadastro(dateNow)
                .motivo(motivoHistorico.getMotivoHistorico())
                .build();

        this.historicoService.save(historico);

        CpuDTO cpuDTO = TypeUtils.parseToDTO(cpu, CpuDTO.class);
        cpuDTO.setFabricante(TypeUtils.parseToDTO(cpu.getFabricante(), FabricanteDTO.class));

        if(cpu.getColaborador() != null) {
            cpuDTO.setColaborador(TypeUtils.parseToDTO(cpu.getColaborador(), ColaboradorDTO.class));
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
        cpu.get().setDataAlteracao(DateUtils.getCurrentDate());

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
        cpu.setDataAlteracao(DateUtils.getCurrentDate());

        return cpu;
    }
}
