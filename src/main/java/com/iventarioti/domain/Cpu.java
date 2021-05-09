package com.iventarioti.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "t_cpu")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Cpu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long id;

	@Column(name = "fabricante")
	private String fabricante;

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

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "fk_colaborador")
	@JsonManagedReference
	private Colaborador colaborador;

	@Column(name = "data_alteracao")
	private Date dataAlteracao;

	public Cpu(String fabricante, String modelo, Integer ano, String numeroSerie, String processador, Integer memoria,
			Integer hdd, Integer ssd, String observacao, Colaborador colaborador, Date dataAlteracao, String status) {
		super();
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.ano = ano;
		this.numeroSerie = numeroSerie;
		this.processador = processador;
		this.memoria = memoria;
		this.hdd = hdd;
		this.ssd = ssd;
		this.observacao = observacao;
		this.colaborador = colaborador;
		this.dataAlteracao = dataAlteracao;
		this.status = status;
	}

	public Cpu() {
		super();
	}

}
