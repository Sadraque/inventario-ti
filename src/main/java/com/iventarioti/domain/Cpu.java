package com.iventarioti.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;



@Entity
@Table(name = "t_cpu")
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Cpu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long id;

	@Column(name = "fk_fabricante")
	private Long fabricante;

	@Column(name = "modelo")
	private String modelo;

	@Column(name = "ano")
	private Integer ano;

	@Column(name = "numero_serie")
	private String numeroSerie;

	@Column(name = "processador")
	private String processador;

	@Column(name = "memoria_ram")
	private Integer memoria;

	@Column(name = "memoria_hdd")
	private Integer hdd;

	@Column(name = "memoria_ssd")
	private Integer ssd;

	@Column(name = "observacao")
	private String observacao;

	@Column(name = "status")
	private String status;

	@Column(name = "fk_colaborador")
	private Long colaborador;

	@Column(name = "data_cadastro")
	private Date dataCadastro;

	@Column(name = "data_alteracao")
	private Date dataAlteracao;

	@Column(name = "excluido")
	private boolean excluido;

}
