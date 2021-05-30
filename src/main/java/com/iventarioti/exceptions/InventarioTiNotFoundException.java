package com.iventarioti.exceptions;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InventarioTiNotFoundException extends ServiceException {
    public InventarioTiNotFoundException(String message) {
        super(message);
    }
}
