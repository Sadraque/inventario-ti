package com.iventarioti.domain;

import javax.persistence.*;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "t_endereco")
@ToString
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Endereco extends BasicEntity {

	private String endereco;
	private Integer numero;
	private String bairro;
	private String complemento;
	private Integer cep;
	private String cidade;
	private String uf;

}
