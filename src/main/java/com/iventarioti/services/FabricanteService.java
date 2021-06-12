package com.iventarioti.services;

import com.iventarioti.domain.Fabricante;
import com.iventarioti.dto.FabricanteDTO;
import com.iventarioti.exceptions.InventarioTiNotFoundException;
import com.iventarioti.repositories.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FabricanteService {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    public FabricanteDTO findById(Long id) {
        Optional<Fabricante> fabricante = this.fabricanteRepository.findById(id);

        if(fabricante.isEmpty()) {
            throw new InventarioTiNotFoundException("Fabricante não encontrado.");
        }

        return new FabricanteDTO(fabricante.get());
    }

    public List<FabricanteDTO> findAll() {
        List<Fabricante> list = this.fabricanteRepository.findAll();

        if(list.isEmpty()) {
            throw new InventarioTiNotFoundException("Nenhum Fabricante encontrado.");
        }

        List<FabricanteDTO> fabricantes = new ArrayList<>();

        list.forEach(fabricante -> {
            fabricantes.add(new FabricanteDTO(fabricante));
        });

        return fabricantes;
    }

    public FabricanteDTO save(FabricanteDTO dto) {
        return new FabricanteDTO(this.fabricanteRepository.save(dtoToEntity(dto)));
    }

    public FabricanteDTO update(Long id, FabricanteDTO dto) {
        Optional<Fabricante> entity = this.fabricanteRepository.findById(id);

        if(entity.isEmpty()) {
            throw new InventarioTiNotFoundException("Fabricante não encontrado.");
        }

        entity.get().setNome(dto.getNome());
        entity.get().setDescricao(dto.getDescricao());

        this.fabricanteRepository.save(entity.get());

        dto.setId(id);
        return dto;
    }

    public void delete(Long id) {
        if(this.fabricanteRepository.findById(id).isEmpty()) {
            throw new InventarioTiNotFoundException("Fabricante não encontrado.");
        }

        this.fabricanteRepository.deleteById(id);
    }

    private Fabricante dtoToEntity(FabricanteDTO dto) {
        Fabricante fabricante = new Fabricante();

        fabricante.setNome(dto.getNome());
        fabricante.setDescricao(dto.getDescricao());

        return fabricante;
    }
}
