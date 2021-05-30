package com.iventarioti.domain.dto;

import lombok.*;

@Data
public class EnderecoDTO {
	private Integer id;
	private String endereco;
	private Integer numero;
	private String bairro;
	private Integer cep;
	private CidadeDTO cidadeDTO;
}
