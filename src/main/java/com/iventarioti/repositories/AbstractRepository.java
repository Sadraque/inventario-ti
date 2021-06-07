package com.iventarioti.repositories;

import com.iventarioti.domain.BasicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbstractRepository<T extends BasicEntity> extends JpaRepository<T,Long> {
}
