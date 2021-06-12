package com.iventarioti.controllers;

import com.iventarioti.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.estadoService.findById(id));
    }

    @GetMapping("/find-all")
    public ResponseEntity findAll() {
        return ResponseEntity.ok().body(this.estadoService.findAll());
    }

}
