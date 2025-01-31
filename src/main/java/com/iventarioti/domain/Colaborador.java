package com.iventarioti.domain;

import javax.persistence.*;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_colaborador")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Where(clause = "excluido = false")
public class Colaborador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "sq_colaborador", allocationSize = 1)
	@GeneratedValue(generator = "sq_colaborador")
	@Column(name = "codigo")
	private Long id;

	@NotNull
	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "email")
	private String email;

	@Column(name = "telefone")
	private String telefone;

	@JoinColumn(name = "fk_profissao")
	@ManyToOne
	private Profissao profissao;

	@JoinColumn(name = "fk_endereco")
	@ManyToOne
	private Endereco endereco;

	@Column(name = "data_cadastro")
	private Date dataCadastro;

	@Column(name = "data_alteracao")
	private Date dataAlteracao;

	@Column(name = "excluido")
	private Boolean excluido;

}
