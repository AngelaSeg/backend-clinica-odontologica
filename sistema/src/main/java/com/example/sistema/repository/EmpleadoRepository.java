package com.example.sistema.repository;

import com.example.sistema.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    // Opcional pero muy útil: Buscar empleado por su número de identificación
    // Spring Boot crea este método automáticamente solo por cómo lo nombramos
    Empleado findByNroIdentificacion(String nroIdentificacion);
}