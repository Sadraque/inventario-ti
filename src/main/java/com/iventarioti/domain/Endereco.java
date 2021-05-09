package com.iventarioti.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "t_endereco")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long id;

	@Column(name = "endereco")
	private String endereco;

	@Column(name = "numero")
	private Integer numero;

	@Column(name = "bairro")
	private String bairro;

	@Column(name = "cep")
	private Integer cep;

	@ManyToOne 
	@JoinColumn(name = "fk_cidade")
	private Cidade cidade;

	@Column(name = "data_alteracao")
	private Date dataAlteracao;

	public Endereco(String endereco, Integer numero, String bairro, Integer cep, Cidade cidade, Date dataAlteracao) {
		super();
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.dataAlteracao = dataAlteracao;
	}

	public Endereco() {
		super();
	}

}
