package com.laplacitacolombiana.springboot.controller;

import com.laplacitacolombiana.springboot.model.Producto;
import com.laplacitacolombiana.springboot.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService service;

    // Obtener todos los productos
    @GetMapping
    public List<Producto> getAll() {
        return service.findAll();
    }

    // Obtener producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear producto
    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestBody Producto p) {
        service.save(p);
        return ResponseEntity.ok("Producto creado correctamente");
    }

    // Editar producto
    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editar(@PathVariable Long id, @RequestBody Producto p) {
        Optional<Producto> existente = service.findById(id);
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Producto no encontrado");

        } else {
            existente.get().setNombre(p.getNombre());
            existente.get().setPrecio(p.getPrecio());
            existente.get().setDescripcion(p.getDescripcion());
            existente.get().setCantidad(p.getCantidad());
            existente.get().setPresentacion(p.getPresentacion());
            existente.get().setUnidadMedida(p.getUnidadMedida());
            existente.get().setImagen(p.getImagen());
            existente.get().setFechaRegistro(p.getFechaRegistro());
            existente.get().setEstado(p.getEstado());
            existente.get().setCategoria(p.getCategoria());
            existente.get().setProveedor(p.getProveedor());

            service.save(existente.orElse(null));
            return ResponseEntity.ok("El producto se editó correctamente");
        }
    }

    // Eliminar producto
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Producto eliminado correctamente");
    }
}


