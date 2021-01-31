package com.iventarioti.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Cpu implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private Integer colaborador_id;

	public Cpu(String fabricante, String modelo, Integer ano, String numeroSerie, String processador, Integer memoria,
			Integer hdd, Integer ssd, String obs) {
		super();
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.ano = ano;
		this.numeroSerie = numeroSerie;
		this.processador = processador;
		this.memoria = memoria;
		this.hdd = hdd;
		this.ssd = ssd;
		this.obs = obs;
	}

	public Cpu() {
		super();
	}
	
	

}
