package com.javier.apidemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService 
{

    private List<User> users = new ArrayList<>();
    private int nextId = 1;

    public List<User> getUsers() 
    {
        return users;
    }

    public User createUser(User user) 
    {
        user.setId(nextId);
        nextId++;
        users.add(user);
        return user;
    }

    public User getUserById(Integer id)
    {
        for (User user : users)
        {
            if (user.getId().equals(id))
            {
                return user;
            }
        }

        throw new UserNotFoundException(id);
    }
}