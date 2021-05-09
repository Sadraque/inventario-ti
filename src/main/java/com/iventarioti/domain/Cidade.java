package com.iventarioti.domain;

import java.io.Serializable;

import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "t_cidade")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Cidade implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "codigo")
	private Long codigo;

	@Column(name = "nome")
	private String nome;

	@Column(name = "uf")
	private String uf;

	public Cidade(Long codigo, String nome, String uf) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.uf = uf;
	}
	
	public Cidade() {
		super();
	}

}
