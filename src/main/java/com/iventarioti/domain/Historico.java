package com.iventarioti.domain;

import lombok.AllArgsConstructor;
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
public class Historico implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo")
    private Long id;

    @Column(name = "fk_cpu")
    private Long fk_cpu;

    @Column(name = "fk_colaborador")
    private Long fk_colaborador;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "data_cadastro")
    private Date dataCadastro;
}
