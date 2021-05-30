package com.iventarioti.domain;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "t_colaborador")
@Where(clause = "excluido = false")
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Colaborador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "email")
	private String email;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "fk_profissao")
	private Long profissao;

	@Column(name = "fk_endereco")
	private Long endereco;

	@Column(name = "data_cadastro")
	private Date dataCadastro;

	@Column(name = "data_alteracao")
	private Date dataAlteracao;

	@Column(name = "excluido")
	private boolean excluido;

}
