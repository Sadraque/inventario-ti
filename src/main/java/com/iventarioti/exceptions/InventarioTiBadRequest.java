package com.iventarioti.exceptions;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InventarioTiBadRequest extends ServiceException {
    public InventarioTiBadRequest(String message) {
        super(message);
    }
}
