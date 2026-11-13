package com.example.sistema.controller;

import com.example.sistema.entity.Rol;
import com.example.sistema.repository.RolRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "*")
public class RolController {

    @Autowired
    private RolRepository rolRepository;

    @GetMapping
    public List<Rol> getAllRoles() {
        return rolRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> getRolById(@PathVariable Long id) {
        Optional<Rol> rol = rolRepository.findById(id);
        return rol.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Rol createRol(@Valid @RequestBody Rol rol) {
        return rolRepository.save(rol);
    }

    @PutMapping("/{id}")
    public Rol updateRol(@PathVariable Long id, @Valid @RequestBody Rol rolDetails) {
        Rol rol = rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        rol.setNombre(rolDetails.getNombre());
        rol.setDescripcion(rolDetails.getDescripcion());
        return rolRepository.save(rol);
    }

    @DeleteMapping("/{id}")
    public void deleteRol(@PathVariable Long id) {
        Rol rol = rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        rolRepository.delete(rol);
    }
}