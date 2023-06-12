package com.example.springbooks.bookcrud.dao;

import com.example.springbooks.bookcrud.entity.User;

public interface UserDao {
    User findByUsername(String username);
}
