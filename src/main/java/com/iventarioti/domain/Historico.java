package com.iventarioti.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_historico")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Historico implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "sq_historico", allocationSize = 1)
    @GeneratedValue(generator = "sq_historico")
    @Column(name = "codigo")
    private Long id;

    @Column(name = "fk_cpu")
    private Long fkCpu;

    @Column(name = "fk_colaborador")
    private Long fkColaborador;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "data_cadastro")
    private Date dataCadastro;
}
