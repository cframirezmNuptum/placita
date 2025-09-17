package com.laplacitacolombiana.springboot.controller;

import com.laplacitacolombiana.springboot.model.Venta;
import com.laplacitacolombiana.springboot.service.VentaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public List<Venta> getAll() {
        return ventaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Venta> getById(@PathVariable Long id) {
        return ventaService.findById(id);
    }

    @PostMapping("/crear")
    public Venta create(@RequestBody @Valid Venta venta) {
        return ventaService.save(venta);
    }

    @PutMapping("/editar/{id}")
    public Venta update(@PathVariable Long id, @RequestBody @Valid Venta venta) {
        venta.setId(id);
        return ventaService.save(venta);
    }

    @DeleteMapping("/borrar/{id}")
    public void delete(@PathVariable Long id) {
        ventaService.delete(id);
    }
}

