package com.iventarioti.dto;

import com.iventarioti.domain.Cidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CidadeDTO {
    private Long id;
    private String nome;
    private EstadoDTO estado;
    private Boolean capital;

    public CidadeDTO(Cidade cidade) {
        this.id = cidade.getId();
        this.nome = cidade.getNome();
        this.estado = new EstadoDTO(cidade.getEstado());
        this.capital = cidade.getCapital();
    }
}
