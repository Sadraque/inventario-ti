package com.iventarioti.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeConverter {

    @Autowired
    private ModelMapper modelMapper;

    public <T> T parseToEntity(Object dto, Class<T> entity) {
        return modelMapper.map(dto, entity);
    }

    public <T> T parseToDTO(Object entity, Class<T> dto) {
        return modelMapper.map(entity, dto);
    }

}