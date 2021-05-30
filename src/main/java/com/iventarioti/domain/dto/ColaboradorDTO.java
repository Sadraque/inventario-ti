package com.iventarioti.domain.dto;

import lombok.*;

@Data
public class ColaboradorDTO {
	private Integer id;
	private String nome;
	private String sobrenome;
	private String email;
	private String telefone;
	private String funcao;
	private EnderecoDTO endereco;
}
