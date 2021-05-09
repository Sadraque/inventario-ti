package com.iventarioti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iventarioti.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

}
