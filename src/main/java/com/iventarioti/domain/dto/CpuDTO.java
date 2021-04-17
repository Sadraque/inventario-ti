package com.iventarioti.domain.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CpuDTO {

	private Integer id;
	private String fabricante;
	private String modelo;
	private Integer ano;
	private String numeroSerie;
	private String processador;
	private Integer memoria;
	private Integer hdd;
	private Integer ssd;
	private String obs;
	private ColaboradorDTO colaborador;

}
