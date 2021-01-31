package com.iventarioti.domain;

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
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String endereco;
	private Integer numero;
	private String bairro;
	private Integer cep;
	private Integer cidade_id;
	
	public Endereco(String endereco, Integer numero, String bairro, Integer cep, Cidade cidade) {
		super();
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade_id = cidade.getId();
	}
	
	
}
