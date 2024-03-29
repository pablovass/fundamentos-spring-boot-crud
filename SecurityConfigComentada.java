package com.pablovass.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfigComentada {
    // @Bean   con este metodo liberamos de resposabilidad la dependecia de spring security
//public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    http
//            .authorizeRequests()
//            .anyRequest()
//            .permitAll();
//
//    return http.build();
//}

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http

                .csrf(csrf -> csrf.disable()) //el filtro que bloquea los put
                .cors(Customizer.withDefaults())
                .authorizeRequests()
                .requestMatchers(HttpMethod.GET, "/api/*").permitAll()///api/* mientras mas * mas niveles despues de una barra
                .requestMatchers(HttpMethod.GET, "/api/**").hasRole("ADMIN") // ESTA REGLAS VAS SE PERMITIDO SOLO CON ADMIN
                .requestMatchers(HttpMethod.GET, "/api/**").hasAnyRole("ADMIN", "CUSTOMER")
                .requestMatchers(HttpMethod.PUT).denyAll() //por mas que tenga basic autorization no va a poder haceder
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    //ESTE BEAN TIENE LAS CREDENCIALES PARA MI SPRING SECURITY
    //no se usa porque tengo la clase userSecurityService que hace exacatamente lo mismo que este metodo pero lo va a buscar a la base de datos
  // @Bean
  // public UserDetailsService memoryUsers() {
  //     UserDetails admin = User.builder()
  //             .username("admin")
  //             .password(passwordEncoder().encode("admin")) // spring no te permite poner password por hacemos uso del encoder
  //             .roles("ADMIN")
  //             .build();

  //     UserDetails customer = User.builder()
  //             .username("customer")
  //             .password(passwordEncoder().encode("customer2121")) // spring no te permite poner password por hacemos uso del encoder
  //             .roles("CUSTOMER")
  //             .build();

  //     return new InMemoryUserDetailsManager(admin, customer);
  // }

    //usamos BCrypt proque de lo contrario spring security no te deja compilarlo.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

