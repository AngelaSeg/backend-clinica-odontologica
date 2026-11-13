package com.example.sistema.controller;

import com.example.sistema.security.JwtUtil;
import com.example.sistema.dto.LoginRequest;
import com.example.sistema.dto.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            // 1. Autenticación contra el UserDetailsService y PasswordEncoder
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );

            // 2. Establecer el contexto de seguridad
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // 3. Generación del JWT
            String jwt = jwtUtil.generateToken(loginRequest.getUsername());

            // 4. Retorno de la respuesta estructurada
            return ResponseEntity.ok(new LoginResponse(jwt, loginRequest.getUsername()));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(401).body("Credenciales inválidas o usuario inactivo");
        }
    }
}