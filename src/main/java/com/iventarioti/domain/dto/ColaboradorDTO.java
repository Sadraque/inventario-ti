package com.iventarioti.domain.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ColaboradorDTO {

	private Integer id;
	private String nome;
	private String sobrenome;
	private String email;
	private String telefone;
	private String funcao;
	private EnderecoDTO endereco;
	private List<CpuDTO> cpus = new ArrayList<>();

}
