package com.example.sistema.repository;

import com.example.sistema.entity.Nacionalidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NacionalidadRepository extends JpaRepository<Nacionalidad, Long> {
    // Spring Boot crea automáticamente: findAll(), findById(), save(), deleteById()
}