package com.iventarioti.repositories;

import com.iventarioti.domain.Cidade;
import com.iventarioti.domain.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
