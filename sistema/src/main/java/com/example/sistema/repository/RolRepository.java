package com.example.sistema.repository;

import com.example.sistema.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    // Spring Boot crea automáticamente: findAll(), findById(), save(), deleteById(), etc.
}