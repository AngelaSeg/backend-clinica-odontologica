package com.example.sistema.service;

import com.example.sistema.entity.Usuario;
import com.example.sistema.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNombreUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        // Validación de estado (Ahora evalúa el tipo Boolean)
        if (usuario.getEstado() == null || !usuario.getEstado()) {
            throw new UsernameNotFoundException("La cuenta de usuario se encuentra inactiva");
        }

        // Mapeo de autoridades (Roles)
        String roleName = (usuario.getRol() != null && usuario.getRol().getNombre() != null)
                ? usuario.getRol().getNombre()
                : "USER";

        var authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + roleName));

        return new User(
                usuario.getNombreUsuario(),
                usuario.getPasswordHash(),
                authorities
        );
    }
}