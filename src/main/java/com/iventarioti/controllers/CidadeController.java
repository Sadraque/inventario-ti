package com.iventarioti.controllers;

import com.iventarioti.dto.CidadeDTO;
import com.iventarioti.dto.CidadeSaveDTO;
import com.iventarioti.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.cidadeService.findById(id));
    }

    @GetMapping("/find-all")
    public ResponseEntity findAll() {
        return ResponseEntity.ok().body(this.cidadeService.findAll());
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CidadeSaveDTO dto) {
        return ResponseEntity.ok().body(this.cidadeService.save(dto));
    }

    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody CidadeSaveDTO dto, @PathVariable Long id) {
        return ResponseEntity.ok().body(this.cidadeService.update(id, dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        this.cidadeService.delete(id);

        return ResponseEntity.ok().build();
    }
}
