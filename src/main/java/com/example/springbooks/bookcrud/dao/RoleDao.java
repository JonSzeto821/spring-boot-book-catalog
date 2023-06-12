package com.example.springbooks.bookcrud.dao;

import com.example.springbooks.bookcrud.entity.Role;

public interface RoleDao {

    public Role findRoleByName(String theRoleName);
}
