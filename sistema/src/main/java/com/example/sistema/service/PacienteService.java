package com.example.sistema.service;

import com.example.sistema.entity.Paciente;
import com.example.sistema.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // 👈 Esta anotación le dice a Spring que esta es la capa de lógica de negocio
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    // 1. Listar todos
    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    // 2. Buscar por ID
    public Paciente getPacienteById(Long id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado con ID: " + id));
    }

    // 3. Crear nuevo (Aquí podríamos agregar lógica extra en el futuro)
    public Paciente createPaciente(Paciente paciente) {
        // Ejemplo de lógica de negocio futura:
        // if (pacienteRepository.findByNroIdentificacion(paciente.getNroIdentificacion()) != null) {
        //     throw new RuntimeException("Ya existe un paciente con esa identificación");
        // }
        return pacienteRepository.save(paciente);
    }

    // 4. Actualizar
    public Paciente updatePaciente(Long id, Paciente pacienteDetails) {
        Paciente paciente = getPacienteById(id); // Reutilizamos el método de arriba

        paciente.setTipoIdentificacion(pacienteDetails.getTipoIdentificacion());
        paciente.setNroIdentificacion(pacienteDetails.getNroIdentificacion());
        paciente.setNombres(pacienteDetails.getNombres());
        paciente.setApellidos(pacienteDetails.getApellidos());
        paciente.setSexo(pacienteDetails.getSexo());
        paciente.setFechaIngreso(pacienteDetails.getFechaIngreso());
        paciente.setFechaNacimiento(pacienteDetails.getFechaNacimiento());
        paciente.setCorreo(pacienteDetails.getCorreo());
        paciente.setEstadoCivil(pacienteDetails.getEstadoCivil());
        paciente.setTelefono(pacienteDetails.getTelefono());
        paciente.setDireccion(pacienteDetails.getDireccion());
        paciente.setObservacion(pacienteDetails.getObservacion());
        paciente.setCiudadId(pacienteDetails.getCiudadId());
        paciente.setNacionalidadId(pacienteDetails.getNacionalidadId());
        paciente.setEstadoPaciente(pacienteDetails.getEstadoPaciente());

        return pacienteRepository.save(paciente);
    }

    // 5. Eliminar
    public void deletePaciente(Long id) {
        Paciente paciente = getPacienteById(id);
        pacienteRepository.delete(paciente);
    }
}