package com.example.springbooks.bookcrud.service;

import com.example.springbooks.bookcrud.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public User findByUsername(String username);
}
