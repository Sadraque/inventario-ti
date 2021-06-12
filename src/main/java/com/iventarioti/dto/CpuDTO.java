package com.iventarioti.dto;

import com.iventarioti.domain.Cpu;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CpuDTO {
	private Long id;
	private FabricanteDTO fabricante;
	private String modelo;
	private Integer ano;
	private String numeroSerie;
	private String processador;
	private Integer memoriaRam;
	private Integer hdd;
	private Integer ssd;
	private String status;
	private String observacao;
	private ColaboradorDTO colaborador;

	public CpuDTO(Cpu cpu) {
		this.id = cpu.getId();
		this.fabricante = new FabricanteDTO(cpu.getFabricante());
		this.modelo = cpu.getModelo();
		this.ano = cpu.getAno();
		this.numeroSerie = cpu.getNumeroSerie();
		this.processador = cpu.getProcessador();
		this.memoriaRam = cpu.getMemoriaRam();
		this.hdd = cpu.getHdd();
		this.ssd = cpu.getSsd();
		this.status = cpu.getStatus().name();
		this.observacao = cpu.getObservacao();
		this.colaborador = new ColaboradorDTO(cpu.getColaborador());
	}
}
