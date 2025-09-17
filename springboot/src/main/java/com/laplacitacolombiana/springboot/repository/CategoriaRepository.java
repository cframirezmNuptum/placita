package com.laplacitacolombiana.springboot.repository;

import com.laplacitacolombiana.springboot.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {}

