package com.iventarioti.dto;

import com.iventarioti.domain.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoSaveDTO {
	private String endereco;
	private Integer numero;
	private String bairro;
	private String complemento;
	private Integer cep;
	private Long cidade;
}
