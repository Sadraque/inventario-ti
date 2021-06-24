package com.iventarioti.controllers;

import com.iventarioti.dto.CpuSaveDTO;
import com.iventarioti.services.CpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cpus")
public class CpuController {

    @Autowired
    private CpuService cpuService;

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.cpuService.findById(id));
    }

    @GetMapping("/find-all")
    public ResponseEntity findAll() {
        return ResponseEntity.ok().body(this.cpuService.findAll());
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CpuSaveDTO dto) {
        return ResponseEntity.ok().body(this.cpuService.save(dto));
    }

    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody CpuSaveDTO dto, @PathVariable Long id) {
        return ResponseEntity.ok().body(this.cpuService.update(id, dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        this.cpuService.delete(id);

        return ResponseEntity.ok().build();
    }
}
