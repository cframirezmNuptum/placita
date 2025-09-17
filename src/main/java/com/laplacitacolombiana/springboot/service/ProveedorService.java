package com.laplacitacolombiana.springboot.service;

import com.laplacitacolombiana.springboot.model.Proveedor;
import com.laplacitacolombiana.springboot.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> findAll() { return proveedorRepository.findAll(); }

    public Proveedor save(Proveedor proveedor) { return proveedorRepository.save(proveedor); }

    public Optional<Proveedor> findById(Long id) { return proveedorRepository.findById(id); }

    public void delete(Long id) { proveedorRepository.deleteById(id); }
}
