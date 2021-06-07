package com.iventarioti.domain;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "t_colaborador")
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Colaborador extends BasicEntity {

	private String nome;
	private String email;
	private String telefone;

	@Column(name = "fk_profissao")
	private Long profissao;

	@Column(name = "fk_endereco")
	private Long endereco;

}
