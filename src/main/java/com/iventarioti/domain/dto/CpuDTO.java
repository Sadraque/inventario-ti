package com.iventarioti.domain.dto;

import lombok.*;

@Data
public class CpuDTO {
	private Long id;
	private Long fabricante;
	private String modelo;
	private Integer ano;
	private String numeroSerie;
	private String processador;
	private Integer memoria;
	private Integer hdd;
	private Integer ssd;
	private String status;
	private String observacao;
	private Long colaborador;
}
