package com.iventarioti.domain;

import javax.persistence.*;

import com.sun.istack.NotNull;
import lombok.*;

import java.io.Serializable;


@Entity
@Table(name = "t_endereco")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "sq_endereco", allocationSize = 1)
	@GeneratedValue(generator = "sq_endereco")
	@Column(name = "codigo")
	private Long id;

	@NotNull
	@Column(name = "logradouro", nullable = false)
	private String endereco;

	@Column(name = "numero")
	private Integer numero;

	@Column(name = "bairro")
	private String bairro;

	@Column(name = "complemento")
	private String complemento;

	@Column(name = "cep")
	private Integer cep;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "fk_cidade", nullable = false)
	private Cidade cidade;

}
