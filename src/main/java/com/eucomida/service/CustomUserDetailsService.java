package com.eucomida.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    if ("admin".equals(username)) {
      return User.builder()
          .username("admin")
          .password(passwordEncoder.encode("admin123"))  // Senha criptografada
          .roles("USER")
          .build();
    } else {
      throw new UsernameNotFoundException("Usuário não encontrado");
    }
  }
}
