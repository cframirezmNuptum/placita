package com.laplacitacolombiana.springboot.controller;

import com.laplacitacolombiana.springboot.model.Categoria;
import com.laplacitacolombiana.springboot.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> getAll() {
        return categoriaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getById(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaService.findById(id);
        return categoria.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria categoria) {
        Categoria nuevaCategoria = categoriaService.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCategoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Long id, @Valid @RequestBody Categoria categoria) {
        if (!categoriaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        categoria.setId(id);
        Categoria actualizada = categoriaService.save(categoria);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!categoriaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


