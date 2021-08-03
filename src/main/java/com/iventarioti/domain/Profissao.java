package com.iventarioti.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_profissao")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Profissao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "sq_profissao", allocationSize = 1)
    @GeneratedValue(generator = "sq_profissao")
    @Column(name = "codigo")
    private Long id;

    private String titulo;
    private String descricao;

}
