package com.iventarioti.dto;

import com.iventarioti.domain.Estado;
import lombok.Data;

@Data
public class EstadoDTO {
    private Long id;
    private String nome;
    private String uf;

    public EstadoDTO(Estado estado) {
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.uf = estado.getUf();
    }
}
