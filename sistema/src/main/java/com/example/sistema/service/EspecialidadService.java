package com.example.sistema.service;

import com.example.sistema.entity.Especialidad;
import com.example.sistema.repository.EspecialidadRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadService {

    private final EspecialidadRepository especialidadRepository;

    public EspecialidadService(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    // Crear una nueva especialidad
    public Especialidad crear(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    // Listar todas las especialidades
    public List<Especialidad> listarTodas() {
        return especialidadRepository.findAll();
    }

    // Buscar una especialidad por ID
    public Optional<Especialidad> buscarPorId(Integer id) {
        return especialidadRepository.findById(id);
    }

    // Eliminar una especialidad
    public void eliminar(Integer id) {
        especialidadRepository.deleteById(id);
    }
}