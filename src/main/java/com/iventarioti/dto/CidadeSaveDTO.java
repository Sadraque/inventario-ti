package com.iventarioti.dto;

import com.iventarioti.domain.Cidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CidadeSaveDTO {
    private String nome;
    private Long estado;
    private Boolean capital;
}
