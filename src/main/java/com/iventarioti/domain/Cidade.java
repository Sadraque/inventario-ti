package com.iventarioti.domain;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "t_cidade")
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cidade implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "codigo")
	private Long codigo;

	@Column(name = "nome")
	private String nome;

	@Column(name = "uf")
	private String uf;

}
