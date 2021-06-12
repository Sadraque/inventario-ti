package com.iventarioti.repositories;

import com.iventarioti.domain.Colaborador;
import com.iventarioti.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
