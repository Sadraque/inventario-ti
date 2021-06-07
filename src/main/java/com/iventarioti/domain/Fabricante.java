package com.iventarioti.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name = "t_fabricante")
@ToString
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Fabricante extends BasicEntity {

    private String nome;
    private String descricao;
}
