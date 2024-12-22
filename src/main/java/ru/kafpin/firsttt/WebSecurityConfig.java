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
//                        .requestMatchers("/api/automobiles","/api/automobiles/**","/api/providedservices","/api/providedservices/**").hasRole("EMPLOYER")
//                        .requestMatchers("/api/employers","/api/employers/**","/api/services","/api/services/**").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.GET,"/api/services","/api/services/**").authenticated()
//                        .requestMatchers(HttpMethod.GET, "/api/clients","/api/clients/**").hasRole("EMPLOYER")
//                        .requestMatchers(HttpMethod.GET, "/api/automobiles/**","/api/automobiles/**").hasRole("USER")
//                )

//                .anyRequest().authenticated()
//                        .requestMatchers(HttpMethod.GET,"/api/employers/**").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.GET,"/api/login").authenticated()
                        .requestMatchers("/api/login").authenticated()
                        .requestMatchers("/api/employers/**").authenticated()
                        .requestMatchers("/api/services/**").authenticated()
                        .requestMatchers("/api/providedservices/**").authenticated()
                        .requestMatchers("/api/automobiles/**").authenticated()
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
