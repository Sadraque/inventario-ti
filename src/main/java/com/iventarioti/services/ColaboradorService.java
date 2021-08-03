package com.iventarioti.services;

import com.iventarioti.domain.Colaborador;
import com.iventarioti.domain.Endereco;
import com.iventarioti.domain.Profissao;
import com.iventarioti.dto.ColaboradorDTO;
import com.iventarioti.dto.ColaboradorSaveDTO;
import com.iventarioti.exceptions.InventarioTiBadRequestException;
import com.iventarioti.exceptions.InventarioTiNotFoundException;
import com.iventarioti.repositories.ColaboradorRepository;
import com.iventarioti.repositories.EnderecoRepository;
import com.iventarioti.repositories.ProfissaoRepository;
import com.iventarioti.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private ProfissaoRepository profissaoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public ColaboradorDTO findById(Long id) {
        Optional<Colaborador> colaborador = this.colaboradorRepository.findById(id);

        if(colaborador.isEmpty()) {
            throw new InventarioTiNotFoundException("Colaborador não encontrado.");
        }

        return new ColaboradorDTO(colaborador.get());
    }

    public List<ColaboradorDTO> findAll() {
        List<Colaborador> list = this.colaboradorRepository.findAll();

        if(list.isEmpty()) {
            throw new InventarioTiNotFoundException("Nenhum Colaborador encontrado.");
        }

        List<ColaboradorDTO> colaboradores = new ArrayList<>();

        list.forEach(colaborador -> {
            colaboradores.add(new ColaboradorDTO(colaborador));
        });

        return colaboradores;
    }

    public ColaboradorDTO save(ColaboradorSaveDTO dto) {
        Colaborador colaborador = new Colaborador();

        Optional<Endereco> endereco = this.enderecoRepository.findById(dto.getEndereco());

        if(endereco.isEmpty()) {
            throw new InventarioTiBadRequestException("Endereco não existe. Forneca um Id para uma Endereco existente");
        }

        Optional<Profissao> profissao = this.profissaoRepository.findById(dto.getProfissao());

        if(endereco.isEmpty()) {
            throw new InventarioTiBadRequestException("Profissao não existe. Forneca um Id para uma Profissao existente");
        }

        colaborador.setNome(dto.getNome());
        colaborador.setEmail(dto.getEmail());
        colaborador.setTelefone(dto.getTelefone());
        colaborador.setProfissao(profissao.get());
        colaborador.setEndereco(endereco.get());
        colaborador.setDataCadastro(DateUtils.getCurrentDate());
        colaborador.setDataAlteracao(colaborador.getDataCadastro());
        colaborador.setExcluido(false);

        this.colaboradorRepository.save(colaborador);

        return new ColaboradorDTO(colaborador);
    }

    public ColaboradorDTO update(Long id, ColaboradorSaveDTO dto) {
        Optional<Colaborador> entity = this.colaboradorRepository.findById(id);

        if(entity.isEmpty()) {
            throw new InventarioTiNotFoundException("Colaborador não encontrado.");
        }

        Optional<Endereco> endereco = this.enderecoRepository.findById(dto.getEndereco());

        if(endereco.isEmpty()) {
            throw new InventarioTiBadRequestException("Endereco não existe. Forneca um Id para uma Endereco existente");
        }

        Optional<Profissao> profissao = this.profissaoRepository.findById(dto.getProfissao());

        if(profissao.isEmpty()) {
            throw new InventarioTiBadRequestException("Profissao não existe. Forneca um Id para uma Profissao existente");
        }

        entity.get().setNome(dto.getNome());
        entity.get().setEmail(dto.getEmail());
        entity.get().setTelefone(dto.getTelefone());
        entity.get().setProfissao(profissao.get());
        entity.get().setEndereco(endereco.get());

        this.colaboradorRepository.save(setChangeDate(entity.get()));

        return new ColaboradorDTO(entity.get());
    }

    public void delete(Long id) {
        Optional<Colaborador> colaborador = this.colaboradorRepository.findById(id);

        if(colaborador.isEmpty()) {
            throw new InventarioTiNotFoundException("Colaborador não encontrado.");
        }

        colaborador.get().setExcluido(true);

        this.colaboradorRepository.save(setChangeDate(colaborador.get()));
    }

    private Colaborador setChangeDate(Colaborador colaborador) {
        colaborador.setDataAlteracao(DateUtils.getCurrentDate());

        return colaborador;
    }

    private Colaborador setRegistrerDate(Colaborador colaborador) {
        colaborador.setDataCadastro(DateUtils.getCurrentDate());

        return colaborador;
    }
}
