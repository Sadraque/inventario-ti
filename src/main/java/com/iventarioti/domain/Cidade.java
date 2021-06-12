package com.iventarioti.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_cidade")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "codigo")
    private Long id;

    @NotNull
    @Column(name = "nome", nullable = false)
    private String nome;

    @JoinColumn(name = "fk_estado")
    @ManyToOne
    private Estado estado;

    @Column(name = "capital")
    private Boolean capital = false;

}
