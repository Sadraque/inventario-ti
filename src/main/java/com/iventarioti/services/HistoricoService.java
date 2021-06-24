package com.iventarioti.services;

import com.iventarioti.domain.Historico;
import com.iventarioti.enums.MotivoHistoricoEnum;
import com.iventarioti.repositories.HistoricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class HistoricoService {

    @Autowired
    private HistoricoRepository historicoRepository;

    public void save(Historico historico) {
        this.historicoRepository.save(historico);
    }
}
