package com.example.sistema.controller;

import com.example.sistema.entity.Ciudad;
import com.example.sistema.repository.CiudadRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ciudades")
@CrossOrigin(origins = "*")
public class CiudadController {

    @Autowired
    private CiudadRepository ciudadRepository;

    @GetMapping
    public List<Ciudad> getAllCiudades() {
        return ciudadRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ciudad> getCiudadById(@PathVariable Long id) {
        Optional<Ciudad> ciudad = ciudadRepository.findById(id);
        return ciudad.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Ciudad createCiudad(@Valid @RequestBody Ciudad ciudad) {
        return ciudadRepository.save(ciudad);
    }

    @PutMapping("/{id}")
    public Ciudad updateCiudad(@PathVariable Long id, @Valid @RequestBody Ciudad ciudadDetails) {
        Ciudad ciudad = ciudadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ciudad no encontrada"));

        ciudad.setDescripcion(ciudadDetails.getDescripcion());
        return ciudadRepository.save(ciudad);
    }

    @DeleteMapping("/{id}")
    public void deleteCiudad(@PathVariable Long id) {
        Ciudad ciudad = ciudadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ciudad no encontrada"));
        ciudadRepository.delete(ciudad);
    }
}