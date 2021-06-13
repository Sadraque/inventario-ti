package com.iventarioti.controllers;

import com.iventarioti.dto.EnderecoSaveDTO;
import com.iventarioti.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.enderecoService.findById(id));
    }

    @GetMapping("/find-all")
    public ResponseEntity findAll() {
        return ResponseEntity.ok().body(this.enderecoService.findAll());
    }

    @PostMapping
    public ResponseEntity save(@RequestBody EnderecoSaveDTO dto) {
        return ResponseEntity.ok().body(this.enderecoService.save(dto));
    }

    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody EnderecoSaveDTO dto, @PathVariable Long id) {
        return ResponseEntity.ok().body(this.enderecoService.update(id, dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        this.enderecoService.delete(id);

        return ResponseEntity.ok().build();
    }
}
