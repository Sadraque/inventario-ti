package com.iventarioti.exceptions;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InventarioTiBadRequestException extends ServiceException {
    public InventarioTiBadRequestException(String message) {
        super(message);
    }
}
