package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.User;

@Controller
public class AuthController {
    private User registeredUser;
    private boolean isAuthenticated = false;

    @GetMapping("/")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password, Model model) {
        if (username.isEmpty() || password.isEmpty()) {
            model.addAttribute("error", "Имя пользователя и пароль не должны быть пустыми!");
            return "register";
        }
        registeredUser = new User(username, password);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password, Model model) {
        if (registeredUser == null ||
                !registeredUser.getUsername().equals(username) ||
                !registeredUser.getPassword().equals(password)) {
            model.addAttribute("error", "Неверное имя пользователя или пароль!");
            return "login";
        }
        isAuthenticated = true;
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String showHomePage(Model model) {
        if (!isAuthenticated) {
            return "redirect:/login";
        }
        model.addAttribute("username", registeredUser.getUsername());
        return "home";
    }

    @PostMapping("/home")
    public String search(@RequestParam String formType,
                         @RequestParam String query, Model model) {
        if ("search".equals(formType)) {
            List<String> results = performSearch(query);
            model.addAttribute("query", query);
            model.addAttribute("results", results);
        }
        model.addAttribute("username", registeredUser.getUsername());
        return "home";
    }

    private List<String> performSearch(String query) {
        List<String> allData = List.of("Лучший язык программирование", "А это есть на Javarush?", "Стоит ли учить Java?");
        List<String> results = new ArrayList<>();
        String lowerCaseQuery = query.toLowerCase();
        for (String data : allData) {
            if (data.toLowerCase().contains(lowerCaseQuery)) {
                results.add(data);
            }
        }
        return results;
    }
}
