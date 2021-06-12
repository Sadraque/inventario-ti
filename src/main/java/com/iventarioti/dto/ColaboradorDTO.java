package com.iventarioti.dto;

import com.iventarioti.domain.Colaborador;
import lombok.*;

@Data
public class ColaboradorDTO {
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private ProfissaoDTO profissao;
	private EnderecoDTO endereco;

	public ColaboradorDTO(Colaborador colaborador) {
		this.id = colaborador.getId();
		this.nome = colaborador.getNome();
		this.email = colaborador.getEmail();
		this.telefone = colaborador.getTelefone();
		this.profissao = new ProfissaoDTO(colaborador.getProfissao());
		this.endereco = new EnderecoDTO(colaborador.getEndereco());
	}
}
