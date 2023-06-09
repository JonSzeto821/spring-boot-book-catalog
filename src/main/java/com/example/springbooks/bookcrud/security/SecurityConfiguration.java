package com.example.springbooks.bookcrud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        // restrict access based on the http request
        httpSecurity.authorizeHttpRequests(configurer ->
                configurer
                        .anyRequest()
                        .authenticated()
        )
                // direct user to the custom login form
                .formLogin(form ->
                        form
                                .loginPage("/showCustomLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                )
                .logout(logout -> logout.permitAll());

        return httpSecurity.build();
    }

}
