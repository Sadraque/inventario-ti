package com.iventarioti.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColaboradorSaveDTO {
	private String nome;
	private String email;
	private String telefone;
	private Long profissao;
	private Long endereco;
}
