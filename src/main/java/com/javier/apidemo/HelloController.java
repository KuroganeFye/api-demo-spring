package com.javier.apidemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController 
{

    @GetMapping("/hello")
    public String hello() 
    {
        return "Hola Javier, tu API ya funciona 🚀";
    }
}
