package com.laplacitacolombiana.springboot.repository;

import com.laplacitacolombiana.springboot.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Long> {}

