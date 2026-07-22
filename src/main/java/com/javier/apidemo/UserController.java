package com.javier.apidemo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.PathVariable;
@RestController
@RequestMapping("/api")
public class UserController 
{
    private final UserService userService;
    public UserController(UserService userService) 
    {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() 
    {
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Integer id)
    {
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) 
    {
        // Here you can perform any necessary operations with the user object, such as saving it to a database or performing validation.
        // For demonstration purposes, we'll just return the received user object.
        return userService.createUser(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User user)
    {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)  // Esto manda un código 204 (sin contenido), es la mejor práctica al borrar
    public void deleteUser(@PathVariable Integer id)
    {
        userService.deleteUser(id);
    }
}
