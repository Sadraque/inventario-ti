package com.iventarioti.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "t_fabricante")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Fabricante implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "codigo")
    private Long id;

    private String nome;
    private String descricao;
}
