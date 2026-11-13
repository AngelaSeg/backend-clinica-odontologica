package com.example.sistema.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 1. Obtener el token del encabezado (Header) de la petición
        String authHeader = request.getHeader("Authorization");

        // 2. Si no hay token o no empieza con "Bearer ", dejamos pasar la petición al siguiente filtro
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // 3. Extraer el token (quitamos la palabra "Bearer ")
        String token = authHeader.substring(7);
        String username = jwtUtil.extractUsername(token);

        // 4. Si el usuario es válido y no está autenticado todavía en esta petición
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            // Validamos el token
            if (jwtUtil.validateToken(token, username)) {
                // Creamos el objeto de autenticación y se lo pasamos a Spring Security
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        // 5. Continuamos con la cadena de filtros
        filterChain.doFilter(request, response);
    }
}