package com.iventarioti.controllers;

import com.iventarioti.dto.ColaboradorSaveDTO;
import com.iventarioti.services.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.colaboradorService.findById(id));
    }

    @GetMapping("/find-all")
    public ResponseEntity findAll() {
        return ResponseEntity.ok().body(this.colaboradorService.findAll());
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ColaboradorSaveDTO dto) {
        return ResponseEntity.ok().body(this.colaboradorService.save(dto));
    }

    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody ColaboradorSaveDTO dto, @PathVariable Long id) {
        return ResponseEntity.ok().body(this.colaboradorService.update(id, dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        this.colaboradorService.delete(id);

        return ResponseEntity.ok().build();
    }
}
