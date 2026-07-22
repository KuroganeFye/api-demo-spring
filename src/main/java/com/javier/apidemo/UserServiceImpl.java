package com.javier.apidemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{

    private List<User> users = new ArrayList<>();
    private int nextId = 1;

    @Override
    public List<User> getUsers() 
    {
        return users;
    }

    @Override
    public User createUser(User user) 
    {
        
        if (user.getAge() < 0)
        {
            throw new InvalidUserException("Age cannot be negative");
        }
        else if (user.getName() == null || user.getName().isEmpty())
        {
            throw new InvalidUserException("Name cannot be empty");
        }

        user.setId(nextId);
        nextId++;
        users.add(user);
        return user;
    }

    @Override
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

    @Override
    public User updateUser(Integer id, User updatedUser) 
    {
        // 1. Reutilizamos tu método para ver si existe (si no, lanza el 404 solito)
        User existingUser = getUserById(id);

        // 2. Validamos que no nos manden datos basura
        if (updatedUser.getAge() < 0) {
            throw new InvalidUserException("Age cannot be negative");
        }
        else if (updatedUser.getName() == null || updatedUser.getName().isEmpty()) {
            throw new InvalidUserException("Name cannot be empty");
        }

        // 3. Actualizamos los datos en memoria
        existingUser.setName(updatedUser.getName());
        existingUser.setAge(updatedUser.getAge());
        
        return existingUser;
    }

    @Override
    public void deleteUser(Integer id) 
    {
        // Igual, verificamos que exista y lo borramos de la lista
        User user = getUserById(id);
        users.remove(user);
    }
}