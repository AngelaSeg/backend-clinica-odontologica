package com.example.sistema.repository;

import com.example.sistema.entity.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
    // Spring Boot crea automáticamente: findAll(), findById(), save(), deleteById(), etc.
}