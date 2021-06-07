package com.iventarioti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.iventarioti.domain.Cpu;

@Repository
public interface CpuRepository extends AbstractRepository<Cpu>, JpaRepository<Cpu, Long>{

}
