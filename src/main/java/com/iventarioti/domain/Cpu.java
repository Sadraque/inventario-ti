package com.iventarioti.domain;

import com.iventarioti.enums.CpuStatus;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_cpu")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cpu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "codigo")
	private Long id;

	@Column(name = "modelo")
	private String modelo;

	@Column(name = "ano")
	private Integer ano;

	@Column(name = "observacao")
	private String observacao;

	@Column(name = "processador")
	private String processador;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private CpuStatus status;

	@Column(name = "numero_serie")
	private String numeroSerie;

	@Column(name = "memoria_ram")
	private Integer memoriaRam;

	@Column(name = "memoria_hdd")
	private Integer hdd;

	@Column(name = "memoria_ssd")
	private Integer ssd;

	@OneToOne
	@JoinColumn(name = "fk_colaborador")
	private Colaborador colaborador;

	@ManyToOne
	@JoinColumn(name = "fk_fabricante")
	private Fabricante fabricante;

	@Column(name = "data_cadastro")
	private Date dataCadastro;

	@Column(name = "data_alteracao")
	private Date dataAlteracao;

	@Column(name = "excluido")
	private Boolean excluido;

}
