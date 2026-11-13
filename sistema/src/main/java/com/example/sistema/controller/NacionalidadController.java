package com.example.sistema.controller;

import com.example.sistema.entity.Nacionalidad;
import com.example.sistema.repository.NacionalidadRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nacionalidades")
@CrossOrigin(origins = "*")
public class NacionalidadController {

    @Autowired
    private NacionalidadRepository nacionalidadRepository;

    @GetMapping
    public List<Nacionalidad> getAllNacionalidades() {
        return nacionalidadRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nacionalidad> getNacionalidadById(@PathVariable Long id) {
        Optional<Nacionalidad> nacionalidad = nacionalidadRepository.findById(id);
        return nacionalidad.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Nacionalidad createNacionalidad(@Valid @RequestBody Nacionalidad nacionalidad) {
        return nacionalidadRepository.save(nacionalidad);
    }

    @PutMapping("/{id}")
    public Nacionalidad updateNacionalidad(@PathVariable Long id, @Valid @RequestBody Nacionalidad nacionalidadDetails) {
        Nacionalidad nacionalidad = nacionalidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nacionalidad no encontrada"));

        nacionalidad.setDescripcion(nacionalidadDetails.getDescripcion());
        return nacionalidadRepository.save(nacionalidad);
    }

    @DeleteMapping("/{id}")
    public void deleteNacionalidad(@PathVariable Long id) {
        Nacionalidad nacionalidad = nacionalidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nacionalidad no encontrada"));
        nacionalidadRepository.delete(nacionalidad);
    }
}