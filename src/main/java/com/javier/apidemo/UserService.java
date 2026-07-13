package com.javier.apidemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService 
{

    private List<User> users = new ArrayList<>();

    public List<User> getUsers() 
    {
        return users;
    }

    public User createUser(User user) 
    {
        users.add(user);
        return user;
    }
}