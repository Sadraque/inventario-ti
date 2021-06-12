package com.iventarioti.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_profissao")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Profissao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long id;

    private String titulo;
    private String descricao;

}
