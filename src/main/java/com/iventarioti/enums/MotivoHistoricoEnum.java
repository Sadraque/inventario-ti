package com.iventarioti.enums;

public enum MotivoHistoricoEnum {
    CADASTRO("CADASTRO"),
    REMANEJAMENTO("REMANEJAMENTO"),
    DEVOLUCAO("DEVOLUCAO"),
    EMPRESTIMO("EMPRESTIMO"),
    ASSISTENCIA("ASSISTENCIA");

    private String motivoHistorico;

    MotivoHistoricoEnum(String motivoHistorico) {
        this.motivoHistorico = motivoHistorico;
    }

    public String getMotivoHistorico() {
        return motivoHistorico;
    }
}
