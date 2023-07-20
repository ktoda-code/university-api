package com.ktoda.cruddemo.security.old;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Deprecated
// @Configuration
public class StudentInMemoryConfig {

    //    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("STUDENT")
                .build();

        UserDetails adam = User.builder()
                .username("adam")
                .password("{noop}test123")
                .roles("STUDENT", "TEACHER", "ADMIN")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("STUDENT", "TEACHER")
                .build();

        return new InMemoryUserDetailsManager(john, adam, susan);
    }

    //    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
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
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}
