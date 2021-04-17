package com.iventarioti.domain.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class EnderecoDTO {

	private Integer id;
	private String endereco;
	private Integer numero;
	private String bairro;
	private Integer cep;
	private CidadeDTO cidadeDTO;

}
