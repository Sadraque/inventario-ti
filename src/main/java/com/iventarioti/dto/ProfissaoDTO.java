package com.iventarioti.dto;

import com.iventarioti.domain.Profissao;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfissaoDTO {
    private Long id;
    private String descricao;
    private String titulo;

    public ProfissaoDTO(Profissao profissao) {
        this.id = profissao.getId();
        this.descricao = profissao.getDescricao();
        this.titulo = profissao.getTitulo();
    }
}
