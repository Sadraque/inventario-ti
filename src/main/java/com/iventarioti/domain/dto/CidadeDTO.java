package com.iventarioti.domain.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CidadeDTO {

	private Integer id;
	private Integer codigo;
	private String nome;
	private String uf;

}
