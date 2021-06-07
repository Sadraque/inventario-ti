package com.iventarioti.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name = "t_profissao")
@ToString
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Profissao extends BasicEntity {

    private String titulo;
    private String descricao;

}
