package com.example.sistema.controller;

import com.example.sistema.entity.Empleado;
import com.example.sistema.repository.EmpleadoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/empleados")
@CrossOrigin(origins = "*")
public class EmpleadoController {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping
    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> getEmpleadoById(@PathVariable Long id) {
        Optional<Empleado> empleado = empleadoRepository.findById(id);
        return empleado.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Empleado createEmpleado(@Valid @RequestBody Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @PutMapping("/{id}")
    public Empleado updateEmpleado(@PathVariable Long id, @Valid @RequestBody Empleado empleadoDetails) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        empleado.setTipoIdentificacion(empleadoDetails.getTipoIdentificacion());
        empleado.setNroIdentificacion(empleadoDetails.getNroIdentificacion());
        empleado.setNombres(empleadoDetails.getNombres());
        empleado.setApellidos(empleadoDetails.getApellidos());
        empleado.setSexo(empleadoDetails.getSexo());
        empleado.setRolId(empleadoDetails.getRolId());
        empleado.setFechaIngreso(empleadoDetails.getFechaIngreso());
        empleado.setCorreo(empleadoDetails.getCorreo());
        empleado.setTelefono(empleadoDetails.getTelefono());
        empleado.setDireccion(empleadoDetails.getDireccion());
        empleado.setEstadoEmpleado(empleadoDetails.getEstadoEmpleado());

        return empleadoRepository.save(empleado);
    }

    @DeleteMapping("/{id}")
    public void deleteEmpleado(@PathVariable Long id) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
        empleadoRepository.delete(empleado);
    }
}