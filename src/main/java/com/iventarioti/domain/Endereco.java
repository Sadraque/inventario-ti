package com.iventarioti.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "t_endereco")
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
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

	@Column(name = "fk_cidade")
	private Long cidade;

	@Column(name = "data_cadastro")
	private Date dataCadastro;

	@Column(name = "data_alteracao")
	private Date dataAlteracao;

	@Column(name = "excluido")
	private boolean excluido;

}
