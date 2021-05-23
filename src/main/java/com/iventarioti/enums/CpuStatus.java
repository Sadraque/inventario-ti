package com.iventarioti.enums;

import lombok.Getter;

@Getter
public enum CpuStatus {
    DISPONIVEL("DISPONIVEL"),
    EM_USO("EM_USO"),
    ESTRAGADA("ESTRAGADA"),
    LIXO("LIXO"),
    VENDIDA("VENDIDA");

    private String status;

    CpuStatus(String status) {
        this.status = status;
    }
}
