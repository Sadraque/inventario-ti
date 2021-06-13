package com.iventarioti.services;

import com.iventarioti.domain.Cidade;
import com.iventarioti.domain.Estado;
import com.iventarioti.dto.CidadeDTO;
import com.iventarioti.dto.CidadeSaveDTO;
import com.iventarioti.exceptions.InventarioTiBadRequest;
import com.iventarioti.exceptions.InventarioTiNotFoundException;
import com.iventarioti.repositories.CidadeRepository;
import com.iventarioti.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public CidadeDTO findById(Long id) {
        Optional<Cidade> cidade = this.cidadeRepository.findById(id);

        if(cidade.isEmpty()) {
            throw new InventarioTiNotFoundException("Cidade não encontrada.");
        }

        return new CidadeDTO(cidade.get());
    }

    public List<CidadeDTO> findAll() {
        List<Cidade> list = this.cidadeRepository.findAll();

        if(list.isEmpty()) {
            throw new InventarioTiNotFoundException("Nenhuma Cidade encontrada.");
        }

        List<CidadeDTO> cidades = new ArrayList<>();

        list.forEach(cidade -> {
            cidades.add(new CidadeDTO(cidade));
        });

        return cidades;
    }

    public CidadeDTO save(CidadeSaveDTO dto) {
        Optional<Estado> estado = this.estadoRepository.findById(dto.getEstado());

        if(estado.isEmpty()) {
            throw new InventarioTiBadRequest("Estado não existe. Forneca um Id para um Estado existente");
        }

        Cidade cidade = new Cidade();

        cidade.setCapital(dto.getCapital());
        cidade.setNome(dto.getNome());
        cidade.setEstado(estado.get());

        return new CidadeDTO(this.cidadeRepository.save(cidade));
    }

    public CidadeDTO update(Long id, CidadeSaveDTO dto) {
        Optional<Cidade> entity = this.cidadeRepository.findById(id);

        if(entity.isEmpty()) {
            throw new InventarioTiNotFoundException("Cidade não encontrada.");
        }

        Optional<Estado> estado = this.estadoRepository.findById(dto.getEstado());

        if(estado.isEmpty()) {
            throw new InventarioTiBadRequest("Estado não existe. Forneca um Id para um Estado existente");
        }

        entity.get().setNome(dto.getNome());
        entity.get().setCapital(dto.getCapital());
        entity.get().setEstado(estado.get());

        this.cidadeRepository.save(entity.get());

        dto.setId(id);
        return new CidadeDTO(entity.get());
    }

    public void delete(Long id) {
        if(this.cidadeRepository.findById(id).isEmpty()) {
            throw new InventarioTiNotFoundException("Cidade não encontrada.");
        }

        this.cidadeRepository.deleteById(id);
    }
}
