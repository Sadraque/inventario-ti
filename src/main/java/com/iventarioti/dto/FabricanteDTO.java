package com.iventarioti.dto;

import com.iventarioti.domain.Fabricante;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FabricanteDTO {
    private Long id;
    private String descricao;
    private String nome;

    public FabricanteDTO(Fabricante fabricante) {
        this.id = fabricante.getId();
        this.descricao = fabricante.getDescricao();
        this.nome = fabricante.getNome();
    }
}
