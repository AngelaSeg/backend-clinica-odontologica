package com.example.sistema.controller;

import com.example.sistema.entity.Paciente;
import com.example.sistema.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "*")
public class PacienteController {

    // 👇 CAMBIO 1: Ahora inyectamos el Service (El Supervisor), no el Repository
    @Autowired
    private PacienteService pacienteService;

    // Metodo Get - Listar todos los pacientes
    @GetMapping
    public List<Paciente> getAllPacientes() {
        return pacienteService.getAllPacientes(); // 👇 CAMBIO 2: Llamamos al Service
    }

    // Buscar paciente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable Long id) {
        try {
            // El Service ya se encarga de lanzar el error si no lo encuentra
            Paciente paciente = pacienteService.getPacienteById(id);
            return new ResponseEntity<>(paciente, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Crear nuevo paciente
    @PostMapping
    public Paciente createPaciente(@Valid @RequestBody Paciente paciente) {
        return pacienteService.createPaciente(paciente);
    }

    // Actualizar paciente
    @PutMapping("/{id}")
    public Paciente updatePaciente(@PathVariable Long id,@Valid @RequestBody Paciente pacienteDetails) {
        return pacienteService.updatePaciente(id, pacienteDetails);
    }

    // Eliminar paciente
    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable Long id) {
        pacienteService.deletePaciente(id);
    }
}