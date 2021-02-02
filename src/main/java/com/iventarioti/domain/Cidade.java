package com.iventarioti.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Cidade implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer codigo;
	private String nome;
	private String uf;

	public Cidade(Integer codigo, String nome, String uf) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.uf = uf;
	}
	
	public Cidade() {
		super();
	}

}
