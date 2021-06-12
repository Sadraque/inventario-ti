package com.iventarioti.controllers;

import com.iventarioti.dto.FabricanteDTO;
import com.iventarioti.services.FabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fabricantes")
public class FabricanteController {

    @Autowired
    private FabricanteService fabricanteService;

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.fabricanteService.findById(id));
    }

    @GetMapping("/find-all")
    public ResponseEntity findAll() {
        return ResponseEntity.ok().body(this.fabricanteService.findAll());
    }

    @PostMapping
    public ResponseEntity save(@RequestBody FabricanteDTO dto) {
        return ResponseEntity.ok().body(this.fabricanteService.save(dto));
    }

    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody FabricanteDTO dto, @PathVariable Long id) {
        return ResponseEntity.ok().body(this.fabricanteService.update(id, dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        this.fabricanteService.delete(id);

        return ResponseEntity.ok().build();
    }
}
