package com.eucomida.service;

import com.eucomida.dto.AuthResponse;
import com.eucomida.dto.LoginRequest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  private CustomUserDetailsService userDetailsService;  // Aqui o Spring injetará a implementação de CustomUserDetailsService
  private JwtTokenProvider jwtTokenProvider;  // Classe que gera o token JWT

  public AuthService(CustomUserDetailsService userDetailsService,
      JwtTokenProvider jwtTokenProvider) {
    this.userDetailsService = userDetailsService;
    this.jwtTokenProvider = jwtTokenProvider;
  }

  public AuthResponse authenticate(LoginRequest request) {
    // Primeiro, carregue os dados do usuário a partir da base de dados
    UserDetails userDetails = userDetailsService.loadUserByUsername(request.username());

    // Valide as credenciais
    if (!userDetails.getPassword().equals(request.password())) {
      throw new BadCredentialsException("Credenciais inválidas");
    }

    // Gere o token JWT
    String token = jwtTokenProvider.generateToken(userDetails.getUsername());

    return new AuthResponse(token);
  }
}
