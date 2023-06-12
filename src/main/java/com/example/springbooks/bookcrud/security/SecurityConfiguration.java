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
                .roles("MEMBER", "ADMIN")
                .build();

        UserDetails alexis = User.builder()
                .username("alexis")
                .password("{noop}supersecretpassword123")
                .roles("MEMBER")
                .build();

        UserDetails fabinho = User.builder()
                .username("fabinho")
                .password("{noop}supersecretpassword123")
                .roles("MEMBER", "AUTHOR")
                .build();

        UserDetails harvey = User.builder()
                .username("harvey")
                .password("{noop}supersecretpassword123")
                .roles("TRIAL_USER")
                .build();

        return new InMemoryUserDetailsManager(admin, alexis, fabinho, harvey);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        // restrict access based on the http request
        httpSecurity.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/").hasRole("MEMBER")
                        .requestMatchers("/books/authors/**").hasAnyRole("AUTHOR", "ADMIN")
                        .requestMatchers("/books/admin/**").hasRole("ADMIN")
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
                .logout(logout -> logout.permitAll())
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied"));

        return httpSecurity.build();
    }

}
