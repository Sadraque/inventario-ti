package com.iventarioti.dto;

import com.iventarioti.domain.Endereco;
import lombok.*;

@Data
public class EnderecoDTO {
	private Long id;
	private String endereco;
	private Integer numero;
	private String bairro;
	private String complemento;
	private Integer cep;
	private CidadeDTO cidade;

	public EnderecoDTO(Endereco endereco) {
		this.id = endereco.getId();
		this.endereco = endereco.getEndereco();
		this.numero = endereco.getNumero();
		this.bairro = endereco.getBairro();
		this.numero = endereco.getNumero();
		this.complemento = endereco.getComplemento();
		this.cep = endereco.getCep();
		this.cidade = new CidadeDTO(endereco.getCidade());
	}
}
