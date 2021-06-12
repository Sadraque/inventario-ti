package com.iventarioti.services;

import com.iventarioti.domain.Profissao;
import com.iventarioti.dto.ProfissaoDTO;
import com.iventarioti.exceptions.InventarioTiNotFoundException;
import com.iventarioti.repositories.ProfissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfissaoService {

    @Autowired
    private ProfissaoRepository profissaoRepository;

    public ProfissaoDTO findById(Long id) {
        Optional<Profissao> profissao = this.profissaoRepository.findById(id);

        if(profissao.isEmpty()) {
            throw new InventarioTiNotFoundException("Profissão não encontrada.");
        }

        return new ProfissaoDTO(profissao.get());
    }

    public List<ProfissaoDTO> findAll() {
        List<Profissao> list = this.profissaoRepository.findAll();

        if(list.isEmpty()) {
            throw new InventarioTiNotFoundException("Nenhuma Profissao encontrada.");
        }

        List<ProfissaoDTO> profissoes = new ArrayList<>();

        list.forEach(profissao -> {
            profissoes.add(new ProfissaoDTO(profissao));
        });

        return profissoes;
    }

    public ProfissaoDTO save(ProfissaoDTO dto) {
        return new ProfissaoDTO(this.profissaoRepository.save(dtoToEntity(dto)));
    }

    public ProfissaoDTO update(Long id, ProfissaoDTO dto) {
        Optional<Profissao> entity = this.profissaoRepository.findById(id);

        if(entity.isEmpty()) {
            throw new InventarioTiNotFoundException("Profissão não encontrada.");
        }

        entity.get().setTitulo(dto.getTitulo());
        entity.get().setDescricao(dto.getDescricao());

        this.profissaoRepository.save(entity.get());

        dto.setId(id);
        return dto;
    }

    public void delete(Long id) {
        if(this.profissaoRepository.findById(id).isEmpty()) {
            throw new InventarioTiNotFoundException("Profissão não encontrada.");
        }

        this.profissaoRepository.deleteById(id);
    }

    private Profissao dtoToEntity(ProfissaoDTO dto) {
        Profissao profissao = new Profissao();

        profissao.setTitulo(dto.getTitulo());
        profissao.setDescricao(dto.getDescricao());

        return profissao;
    }
}
