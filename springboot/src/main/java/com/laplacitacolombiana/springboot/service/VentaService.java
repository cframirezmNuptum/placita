package com.laplacitacolombiana.springboot.service;

import com.laplacitacolombiana.springboot.model.Venta;
import com.laplacitacolombiana.springboot.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> findAll() { return ventaRepository.findAll(); }

    public Venta save(Venta venta) { return ventaRepository.save(venta); }

    public Optional<Venta> findById(Long id) { return ventaRepository.findById(id); }

    public void delete(Long id) { ventaRepository.deleteById(id); }
}

