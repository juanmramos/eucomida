package com.eucomida.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/auth/login").permitAll()
            .requestMatchers("/**").permitAll()
            //.requestMatchers("/usuarios/me").permitAll()
            .requestMatchers(
                "/swagger-ui/**",
                "/v3/api-docs/**",
                "/swagger-ui.html"
            ).permitAll() // Libera acesso ao Swagger
            .anyRequest().authenticated() // Protege as outras rotas
        )
        .csrf(csrf -> csrf.disable()) // Desativa CSRF apenas se necessário
        .formLogin(withDefaults()) // Mantém o login padrão
        .httpBasic(withDefaults()); // Mantém autenticação básica

    return http.build();
  }
}
