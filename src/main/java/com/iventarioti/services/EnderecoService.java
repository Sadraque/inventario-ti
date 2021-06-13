package com.iventarioti.services;

import com.iventarioti.domain.Endereco;
import com.iventarioti.domain.Cidade;
import com.iventarioti.dto.EnderecoDTO;
import com.iventarioti.dto.EnderecoSaveDTO;
import com.iventarioti.exceptions.InventarioTiBadRequest;
import com.iventarioti.exceptions.InventarioTiNotFoundException;
import com.iventarioti.repositories.CidadeRepository;
import com.iventarioti.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    public EnderecoDTO findById(Long id) {
        Optional<Endereco> endereco = this.enderecoRepository.findById(id);

        if(endereco.isEmpty()) {
            throw new InventarioTiNotFoundException("Endereco não encontrado.");
        }

        return new EnderecoDTO(endereco.get());
    }

    public List<EnderecoDTO> findAll() {
        List<Endereco> list = this.enderecoRepository.findAll();

        if(list.isEmpty()) {
            throw new InventarioTiNotFoundException("Nenhum Endereco encontrado.");
        }

        List<EnderecoDTO> enderecos = new ArrayList<>();

        list.forEach(endereco -> {
            enderecos.add(new EnderecoDTO(endereco));
        });

        return enderecos;
    }

    public EnderecoDTO save(EnderecoSaveDTO dto) {
        Optional<Cidade> cidade = this.cidadeRepository.findById(dto.getCidade());

        if(cidade.isEmpty()) {
            throw new InventarioTiBadRequest("Cidade não existe. Forneca um Id para uma Cidade existente");
        }

        Endereco endereco = new Endereco();

        endereco.setEndereco(dto.getEndereco());
        endereco.setBairro(dto.getBairro());
        endereco.setNumero(dto.getNumero());
        endereco.setComplemento(dto.getComplemento());
        endereco.setCep(dto.getCep());
        endereco.setCidade(cidade.get());

        return new EnderecoDTO(this.enderecoRepository.save(endereco));
    }

    public EnderecoDTO update(Long id, EnderecoSaveDTO dto) {
        Optional<Endereco> entity = this.enderecoRepository.findById(id);

        if(entity.isEmpty()) {
            throw new InventarioTiNotFoundException("Endereco não encontrado.");
        }

        Optional<Cidade> cidade = this.cidadeRepository.findById(dto.getCidade());

        if(cidade.isEmpty()) {
            throw new InventarioTiBadRequest("Cidade não existe. Forneca um Id para uma Cidade existente");
        }

        entity.get().setEndereco(dto.getEndereco());
        entity.get().setBairro(dto.getBairro());
        entity.get().setNumero(dto.getNumero());
        entity.get().setComplemento(dto.getComplemento());
        entity.get().setCep(dto.getCep());
        entity.get().setCidade(cidade.get());

        this.enderecoRepository.save(entity.get());

        return new EnderecoDTO(entity.get());
    }

    public void delete(Long id) {
        if(this.enderecoRepository.findById(id).isEmpty()) {
            throw new InventarioTiNotFoundException("Endereco não encontrado.");
        }

        this.enderecoRepository.deleteById(id);
    }
}
