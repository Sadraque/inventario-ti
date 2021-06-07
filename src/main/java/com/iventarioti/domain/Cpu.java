package com.iventarioti.domain;

import com.iventarioti.enums.CpuStatus;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "t_cpu")
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cpu extends BasicEntity {

	private String modelo;
	private Integer ano;
	private String observacao;
	private String processador;


	@Enumerated(EnumType.STRING)
	private CpuStatus status;

	@Column(name = "numero_serie")
	private String numeroSerie;

	@Column(name = "memoria_ram")
	private Integer memoria;

	@Column(name = "memoria_hdd")
	private Integer hdd;

	@Column(name = "memoria_ssd")
	private Integer ssd;

	@Column(name = "fk_colaborador")
	private Long colaborador;

	@Column(name = "fk_fabricante")
	private Long fabricante;

}
