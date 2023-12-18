package com.pablovass.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(securedEnabled = true) //por defecto siempre esta en falso
public class SecurityConfig {
// al generar los permisos tener encuenta la lectura de la clase ya que el orden da prioridad a la gerarquia
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http

                .csrf(csrf -> csrf.disable()) //el filtro que bloquea los put
                .cors(Customizer.withDefaults())
                .authorizeRequests()
                .requestMatchers("/api/customers/**").hasAnyRole("ADMIN","CUSTOMER")
                .requestMatchers(HttpMethod.GET, "/api/pizzas/**").hasAnyRole("ADMIN","CUSTOMER")
                .requestMatchers(HttpMethod.POST, "/api/pizzas/**").hasRole("ADMIN") // ESTA REGLAS VAS SE PERMITIDO SOLO CON ADMIN
                .requestMatchers(HttpMethod.PUT).hasRole("ADMIN")
                .requestMatchers("/api/orders/ramdon").hasAuthority("ramdom_order")// le estoy diciendo los usurios que tengan ramdom_oder como permiso podran ver esa peticion
                .requestMatchers("/api/orders/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

