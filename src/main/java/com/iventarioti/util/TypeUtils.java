package com.iventarioti.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class TypeUtils {

    private static ModelMapper modelMapper = new ModelMapper();

    public static <T> T parseToEntity(Object dto, Class<T> entity) {
        return modelMapper.map(dto, entity);
    }

    public static <T> T parseToDTO(Object entity, Class<T> dto) {
        return modelMapper.map(entity, dto);
    }

    public static <T> List<T> parseToDTO(List<?> entity, Class<T> dto) {
        List<T> list = new ArrayList<>();

        entity.forEach(o -> {
            list.add(modelMapper.map(o, dto));
        });

        return list;
    }

    public static <T> List<T> parseToEntity(List<?> dto, Class<T> entity) {
        List<T> list = new ArrayList<>();

        dto.forEach(o -> {
            list.add(modelMapper.map(o, entity));
        });

        return list;
    }

}