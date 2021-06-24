package com.iventarioti.dto;

import com.iventarioti.domain.Cpu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CpuSaveDTO {
	private Long fabricante;
	private String modelo;
	private Integer ano;
	private String numeroSerie;
	private String processador;
	private Integer memoriaRam;
	private Integer hdd;
	private Integer ssd;

	@Nullable
	private String status;

	@Nullable
	private String observacao;

	@Nullable
	private Long colaborador;
}
