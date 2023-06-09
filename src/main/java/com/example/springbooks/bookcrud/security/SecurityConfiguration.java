package com.example.springbooks.bookcrud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}admin")
                .roles("EMPLOYEE", "ADMIN")
                .build();

        UserDetails alexis = User.builder()
                .username("alexis")
                .password("{noop}supersecretpassword123")
                .roles("EMPLOYEE")
                .build();

        UserDetails kephren = User.builder()
                .username("kephren")
                .password("{noop}supersecretpassword123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        return new InMemoryUserDetailsManager(admin, alexis, kephren);
    }

}
