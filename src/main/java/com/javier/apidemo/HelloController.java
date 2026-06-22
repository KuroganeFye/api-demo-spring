package com.javier.apidemo;

import java.util.HashMap;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class HelloController 
{

    @GetMapping("/hello")
    public Map<String, String> hello() 
    {
        Map<String, String> response = new HashMap<>();
        response.put("message", "API funcionando");
        response.put("user", "Javier");
        return response;
    }

    @PostMapping("/users")
    public Map<String, String> createUser(@RequestBody Map<String, String> body) 
    {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Usuario creado");
        response.put("name", body.get("name"));
        return response;
    }
}
