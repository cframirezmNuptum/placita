package com.laplacitacolombiana.springboot.controller;
import com.laplacitacolombiana.springboot.model.DetalleVenta;
import com.laplacitacolombiana.springboot.service.DetalleVentaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detalles-venta")
public class DetalleVentaController {
    @Autowired
    private DetalleVentaService detalleVentaService;

    @GetMapping
    public List<DetalleVenta> getAll() {
        return detalleVentaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<DetalleVenta> getById(@PathVariable Long id) {
        return detalleVentaService.findById(id);
    }

    @PostMapping
    public DetalleVenta create(@Valid @RequestBody DetalleVenta detalleVenta) {
        return detalleVentaService.save(detalleVenta);
    }

    @PutMapping("/{id}")
    public DetalleVenta update(@PathVariable Long id, @Valid @RequestBody DetalleVenta detalleVenta) {
        detalleVenta.setId(id);
        return detalleVentaService.save(detalleVenta);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        detalleVentaService.delete(id);
    }
}



