package com.example.sistema.repository;

import com.example.sistema.entity.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Integer> {
    // No hace falta escribir nada adentro, JpaRepository ya trae save(), findAll(), etc.
}