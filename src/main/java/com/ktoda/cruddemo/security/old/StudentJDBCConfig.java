package com.ktoda.cruddemo.security.old;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Deprecated
// @Configuration
public class StudentJDBCConfig {

    //    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource); // No hard coding users
        // Uses the default scheme Users-Authorities
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
