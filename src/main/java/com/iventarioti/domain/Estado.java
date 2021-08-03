package com.iventarioti.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_estado")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Estado implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "sq_estado", allocationSize = 1)
    @GeneratedValue(generator = "sq_estado")
    @Column(name = "codigo")
    private Long id;

    @NotNull
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotNull
    @Column(name = "sigla", nullable = false)
    private String uf;
}