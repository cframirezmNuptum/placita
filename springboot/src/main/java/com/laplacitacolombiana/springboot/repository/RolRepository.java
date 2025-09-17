package com.laplacitacolombiana.springboot.repository;

import com.laplacitacolombiana.springboot.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {
}

