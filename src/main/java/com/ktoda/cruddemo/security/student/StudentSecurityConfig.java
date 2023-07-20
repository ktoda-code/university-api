package com.ktoda.cruddemo.security.student;

import com.ktoda.cruddemo.service.StudentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class StudentSecurityConfig {
    private final StudentDetailsService studentDetailsService;

    @Autowired
    public StudentSecurityConfig(StudentDetailsService studentDetailsService) {
        this.studentDetailsService = studentDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(config -> config
                .requestMatchers(HttpMethod.GET, "/api/v1/students").hasRole("STUDENT")
                .requestMatchers(HttpMethod.GET, "/api/v1/students/**").hasRole("STUDENT")
                .requestMatchers(HttpMethod.POST, "/api/v1/students").hasRole("TEACHER")
                .requestMatchers(HttpMethod.PUT, "/api/v1/students").hasRole("TEACHER")
                .requestMatchers(HttpMethod.DELETE, "/api/v1/students/**").hasRole("ADMIN")
        );

        // use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross-Site Request Forgery (CSRF), non required for stateless REST Api
        // http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(studentDetailsService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
}
