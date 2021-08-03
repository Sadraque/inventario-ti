package com.iventarioti.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "cidade")
@Table(name = "t_cidade")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "sq_cidade", allocationSize = 1)
    @GeneratedValue(generator = "sq_cidade")
    @Column(name = "codigo", updatable = false)
    private Long id;

    @Column(
            name = "nome",
            nullable = false
    )
    private String nome;

    @JoinColumn(
            name = "fk_estado",
            nullable = false
    )
    @ManyToOne
    private Estado estado;

    @Column(name = "capital")
    private Boolean capital = false;

}
