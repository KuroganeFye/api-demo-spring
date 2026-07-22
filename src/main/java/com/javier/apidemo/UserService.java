package com.javier.apidemo;

import java.util.List;

public interface UserService 
{
    List<User> getUsers();
    User getUserById(Integer id);
    User createUser(User user);
    User updateUser(Integer id, User user);
    void deleteUser(Integer id);
}