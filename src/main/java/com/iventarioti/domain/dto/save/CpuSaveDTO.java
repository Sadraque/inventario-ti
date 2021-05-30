package com.iventarioti.domain.dto.save;

import lombok.*;

@Data
public class CpuSaveDTO {
    private Long fabricante;
    private String modelo;
    private Integer ano;
    private String numeroSerie;
    private String processador;
    private Integer memoria;
    private Integer hdd;
    private Integer ssd;
    private String observacao;
    private Long colaborador;
}
