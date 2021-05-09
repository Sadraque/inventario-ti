package com.iventarioti.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "t_colaborador")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Colaborador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "sobrenome")
	private String sobrenome;

	@Column(name = "email")
	private String email;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "funcao")
	private String funcao;
	
	@ManyToOne 
	@JoinColumn(name = "fk_endereco")
	private Endereco endereco;

	@Column(name = "data_alteracao")
	private Date dataAlteracao;

	@OneToMany(mappedBy = "colaborador")
	@JsonBackReference
	private List<Cpu> cpus = new ArrayList<>();

	public Colaborador(String nome, String sobrenome, String email, String telefone, String funcao, Endereco endereco, Date dataAlteracao) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.telefone = telefone;
		this.funcao = funcao;
		this.endereco = endereco;
		this.dataAlteracao = dataAlteracao;
	}

	public Colaborador() {
		super();
	}

}
