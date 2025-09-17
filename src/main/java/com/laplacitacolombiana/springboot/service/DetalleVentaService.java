package com.laplacitacolombiana.springboot.service;

import com.laplacitacolombiana.springboot.model.DetalleVenta;
import com.laplacitacolombiana.springboot.repository.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleVentaService {
    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    public List<DetalleVenta> findAll() { return detalleVentaRepository.findAll(); }

    public DetalleVenta save(DetalleVenta detalleVenta) { return detalleVentaRepository.save(detalleVenta); }

    public Optional<DetalleVenta> findById(Long id) { return detalleVentaRepository.findById(id); }

    public void delete(Long id) { detalleVentaRepository.deleteById(id); }
}

