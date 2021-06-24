package com.iventarioti.enums;

public enum CpuStatusEnum {
    DISPONIVEL("DISPONIVEL"),
    EM_USO("EM_USO"),
    ESTRAGADA("ESTRAGADA"),
    LIXO("LIXO"),
    VENDIDA("VENDIDA");

    private String status;

    CpuStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
