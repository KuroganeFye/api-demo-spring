package com.javier.apidemo;

public class User 
{

    private Integer id;
    private String name;
    private int age;

    public User() 
    {
    }

    public User(Integer id, String name, int age) 
    {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() 
    {
        return name;
    }

    public int getAge() 
    {
        return age;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public void setAge(int age) 
    {
        this.age = age;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }
}