package com.iventarioti.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "t_fabricante")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Fabricante implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "sq_fabricante", allocationSize = 1)
    @GeneratedValue(generator = "sq_fabricante")
    @Column(name = "codigo")
    private Long id;

    private String nome;
    private String descricao;
}
