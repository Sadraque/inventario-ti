package com.iventarioti.services;

import com.iventarioti.domain.Cidade;
import com.iventarioti.domain.Estado;
import com.iventarioti.dto.CidadeDTO;
import com.iventarioti.dto.CidadeSaveDTO;
import com.iventarioti.exceptions.InventarioTiBadRequestException;
import com.iventarioti.exceptions.InventarioTiNotFoundException;
import com.iventarioti.repositories.CidadeRepository;
import com.iventarioti.repositories.EstadoRepository;
import com.iventarioti.util.TypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        cidadeExists(cidade);

        return TypeConverter.parseToDTO(cidade.get(), CidadeDTO.class);
    }

    public List<CidadeDTO> findAll() {
        List<Cidade> cidades = this.cidadeRepository.findAll();

        cidadeExists(cidades);

        return TypeConverter.parseToDTO(cidades, CidadeDTO.class);
    }

    public CidadeDTO save(CidadeSaveDTO dto) {
        Optional<Estado> estado = this.estadoRepository.findById(dto.getEstado());
        estadoExists(estado);

        Cidade cidade = TypeConverter.parseToEntity(dto, Cidade.class);
        cidade.setEstado(estado.get());

        return TypeConverter.parseToDTO(this.cidadeRepository.save(cidade), CidadeDTO.class);
    }

    public CidadeDTO update(Long id, CidadeSaveDTO dto) {
        cidadeExists(this.cidadeRepository.findById(id));

        Optional<Estado> estado = this.estadoRepository.findById(dto.getEstado());
        estadoExists(estado);

        Cidade cidade = TypeConverter.parseToEntity(dto, Cidade.class);
        cidade.setEstado(estado.get());

        return TypeConverter.parseToDTO(this.cidadeRepository.save(cidade), CidadeDTO.class);
    }

    public void delete(Long id) {
        cidadeExists(this.cidadeRepository.findById(id));

        this.cidadeRepository.deleteById(id);
    }

    private void cidadeExists(Cidade cidade) {
        if(cidade == null) {
            throw new InventarioTiNotFoundException("Cidade não encontrada.");
        }
    }

    private void cidadeExists(Optional<Cidade> cidade) {
        if(cidade.isEmpty()) {
            throw new InventarioTiNotFoundException("Cidade não encontrada.");
        }
    }

    private void cidadeExists(List<Cidade> cidade) {
        if(cidade.isEmpty()) {
            throw new InventarioTiNotFoundException("Nenhuma Cidade encontrada.");
        }
    }

    private void estadoExists(Optional<Estado> estado) {
        if(estado.isEmpty()) {
            throw new InventarioTiBadRequestException("Estado não existe. Forneca um Id para um Estado existente");
        }
    }
}
