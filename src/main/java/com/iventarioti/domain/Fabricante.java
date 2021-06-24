package com.iventarioti.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "t_fabricante")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Fabricante implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo")
    private Long id;

    private String nome;
    private String descricao;
}
