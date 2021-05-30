package com.iventarioti.domain.dto.find;

import com.iventarioti.domain.dto.ColaboradorDTO;
import com.iventarioti.domain.dto.FabricanteDTO;
import lombok.Data;

@Data
public class CpuFindDTO {
    private Long id;
    private FabricanteDTO fabricante;
    private String modelo;
    private Integer ano;
    private String numeroSerie;
    private String processador;
    private Integer memoria;
    private Integer hdd;
    private Integer ssd;
    private String status;
    private String observacao;
    private ColaboradorDTO colaborador;
}
