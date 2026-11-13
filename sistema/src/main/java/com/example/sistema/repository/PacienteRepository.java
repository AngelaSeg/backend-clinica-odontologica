package com.example.sistema.repository;

import com.example.sistema.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    // Opcional pero muy útil: Buscar paciente por su número de identificación
    // Spring Boot crea este método automáticamente solo por cómo lo nombramos
    Paciente findByNroIdentificacion(String nroIdentificacion);
}