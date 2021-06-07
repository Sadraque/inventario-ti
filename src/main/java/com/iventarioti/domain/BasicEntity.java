package com.iventarioti.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@ToString
@SuperBuilder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Where(clause = "excluido = false")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BasicEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "codigo")
    private Long id;

    @Column(name = "data_cadastro")
    private Date dataCadastro;

    @Column(name = "data_alteracao")
    private Date dataAlteracao;

    @Column(name = "excluido")
    private boolean excluido;
}
