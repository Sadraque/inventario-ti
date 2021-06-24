package com.iventarioti.controllers;

import com.iventarioti.dto.ProfissaoDTO;
import com.iventarioti.services.ProfissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profissoes")
public class ProfissaoController {

    @Autowired
    private ProfissaoService profissaoService;

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.profissaoService.findById(id));
    }

    @GetMapping("/find-all")
    public ResponseEntity findAll() {
        return ResponseEntity.ok().body(this.profissaoService.findAll());
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ProfissaoDTO dto) {
        return ResponseEntity.ok().body(this.profissaoService.save(dto));
    }

    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody ProfissaoDTO dto, @PathVariable Long id) {
        return ResponseEntity.ok().body(this.profissaoService.update(id, dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        this.profissaoService.delete(id);

        return ResponseEntity.ok().build();
    }
}
