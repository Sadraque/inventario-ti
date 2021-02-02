package com.iventarioti.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Colaborador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String sobrenome;
	private String email;
	private String telefone;
	private String funcao;
	
	@ManyToOne 
	@JoinColumn(name = "endereco_id") 
	private Endereco endereco;

	@OneToMany(mappedBy = "colaborador")
	@JsonBackReference
	private List<Cpu> cpus = new ArrayList<>();

	public Colaborador(String nome, String sobrenome, String email, String telefone, String funcao, Endereco endereco) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.telefone = telefone;
		this.funcao = funcao;
		this.endereco = endereco;
	}

	public Colaborador() {
		super();
	}

}
