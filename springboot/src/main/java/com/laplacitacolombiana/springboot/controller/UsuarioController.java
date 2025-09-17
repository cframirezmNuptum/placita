package com.laplacitacolombiana.springboot.controller;

import com.laplacitacolombiana.springboot.model.Usuario;
import com.laplacitacolombiana.springboot.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAll() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> getById(@PathVariable Long id) {
        return usuarioService.findById(id);
    }

    @PostMapping
    public Usuario create(@RequestBody @Valid Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody @Valid Usuario usuario) {
        usuario.setId(id);
        return usuarioService.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usuarioService.delete(id);
    }
}



