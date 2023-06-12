package com.example.springbooks.bookcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showCustomLoginPage")
    public String showCustomLoginPage() {

        return "login/login-form";
    }

    @GetMapping("/access-denied")
    public String showAccessDeniedPage() {

        return "login/access-denied";
    }
}
