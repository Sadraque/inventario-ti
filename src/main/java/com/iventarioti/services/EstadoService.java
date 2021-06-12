package com.iventarioti.services;

import com.iventarioti.domain.Estado;
import com.iventarioti.dto.EstadoDTO;
import com.iventarioti.exceptions.InventarioTiNotFoundException;
import com.iventarioti.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public EstadoDTO findById(Long id) {
        Optional<Estado> estado = this.estadoRepository.findById(id);

        if(estado.isEmpty()) {
            throw new InventarioTiNotFoundException("Estado não encontrado.");
        }

        return new EstadoDTO(estado.get());
    }

    public List<EstadoDTO> findAll() {
        List<Estado> list = this.estadoRepository.findAll();

        if(list.isEmpty()) {
            throw new InventarioTiNotFoundException("Nehum Estado encontrado.");
        }

        List<EstadoDTO> estados = new ArrayList<>();

        list.forEach(estado -> {
            estados.add(new EstadoDTO(estado));
        });

        return estados;
    }

    public EstadoDTO save(EstadoDTO dto) {
        return new EstadoDTO(this.estadoRepository.save(dtoToEntity(dto)));
    }

    public EstadoDTO update(Long id, EstadoDTO dto) {
        Optional<Estado> entity = this.estadoRepository.findById(id);

        if(entity.isEmpty()) {
            throw new InventarioTiNotFoundException("Estado não encontrado.");
        }

        entity.get().setNome(dto.getNome());
        entity.get().setUf(dto.getUf());

        this.estadoRepository.save(entity.get());

        dto.setId(id);
        return dto;
    }

    public void delete(Long id) {
        if(this.estadoRepository.findById(id).isEmpty()) {
            throw new InventarioTiNotFoundException("Estado não encontrado.");
        }

        this.estadoRepository.deleteById(id);
    }

    private Estado dtoToEntity(EstadoDTO dto) {
        Estado estado = new Estado();

        dto.setNome(dto.getNome());
        dto.setUf(dto.getUf());

        return estado;
    }
}
