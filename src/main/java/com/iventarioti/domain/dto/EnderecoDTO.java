package com.iventarioti.domain.dto;

import lombok.*;

@Data
public class EnderecoDTO {
	private Integer id;
	private String endereco;
	private Integer numero;
	private String bairro;
	private String complemento;
	private Integer cep;
	private String cidade;
	private String uf;
}
