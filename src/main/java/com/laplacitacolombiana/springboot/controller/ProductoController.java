package com.laplacitacolombiana.springboot.controller;

import com.laplacitacolombiana.springboot.model.Producto;
import com.laplacitacolombiana.springboot.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    private ProductoService service;

    @GetMapping
    public List<Producto> getAll() { return service.findAll(); }
    @PostMapping
    public Producto create(@RequestBody Producto p) { return service.save(p); }
    @GetMapping("/{id}") public ResponseEntity<Producto> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { service.delete(id); }
}

