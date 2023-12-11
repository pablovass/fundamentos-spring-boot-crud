package com.pablovass.config;
/** ESTO ES UNA CONFIGURACION GLOBAL DE CORS */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.Arrays;

public class CorsConfig {
    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration corsConfiguration= new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200")); // aca le avilito los puertos
        corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE")); // aca le avilito los tipos de metodos
        corsConfiguration.setAllowedHeaders(Arrays.asList("*"));

        UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",corsConfiguration); // aca estoy abilitando a todos los controlladores de proyecto
        return source;
    }
}
