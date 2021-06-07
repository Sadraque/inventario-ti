package com.iventarioti.repositories;

import com.iventarioti.domain.Profissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfissaoRepository extends AbstractRepository<Profissao>, JpaRepository<Profissao, Long> {

}
