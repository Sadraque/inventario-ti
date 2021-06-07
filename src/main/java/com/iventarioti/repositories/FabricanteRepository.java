package com.iventarioti.repositories;

import com.iventarioti.domain.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricanteRepository extends AbstractRepository<Fabricante>, JpaRepository<Fabricante, Long> {

}
