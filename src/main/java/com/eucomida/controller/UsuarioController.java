package com.eucomida.controller;

import com.eucomida.entity.UsuarioEntity;
import com.eucomida.repository.UsuarioRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
  private final UsuarioRepository usuarioRepository;

  public UsuarioController(UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
  }

  @GetMapping("/me")
  public UsuarioEntity getUsuarioAutenticado(@AuthenticationPrincipal User user) {
    return usuarioRepository.findByUsername(user.getUsername())
        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
  }
}
