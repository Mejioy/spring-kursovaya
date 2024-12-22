package ru.kafpin.firsttt;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http            .authorizeHttpRequests((auth) -> auth
                        .requestMatchers(HttpMethod.POST,"/api/employers","/api/services").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/api/employers/**","/api/services/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/api/employers/**","/api/services/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.POST,"/api/automobiles","/api/providedservices").hasRole("EMPLOYER")
                        .requestMatchers(HttpMethod.PUT,"/api/automobiles/**","/api/providedservices/**").hasRole("EMPLOYER")
                        .requestMatchers(HttpMethod.DELETE,"/api/automobiles/**","/api/providedservices/**").hasRole("EMPLOYER")

                        .requestMatchers(HttpMethod.GET,"**").authenticated()
                        .requestMatchers("/api/login").authenticated()
                        .requestMatchers(HttpMethod.POST, "/api/registry").anonymous())

                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



}
