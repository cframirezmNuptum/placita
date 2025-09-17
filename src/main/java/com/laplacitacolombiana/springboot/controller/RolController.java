package com.laplacitacolombiana.springboot.controller;

import com.laplacitacolombiana.springboot.model.Rol;
import com.laplacitacolombiana.springboot.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public List<Rol> getAll() {
        return rolService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> getById(@PathVariable Long id) {
        Optional<Rol> rol = rolService.findById(id);
        return rol.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/crear")
    public ResponseEntity<?> create(@Valid @RequestBody Rol rol) {
        return ResponseEntity.ok(rolService.save(rol));
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Rol> update(@PathVariable Long id, @Valid @RequestBody Rol rol) {
        if (!rolService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        rol.setId(id);
        return ResponseEntity.ok(rolService.save(rol));
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!rolService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        rolService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

