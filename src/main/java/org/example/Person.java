package org.example;

import java.util.Date;

public class Person extends Animal{
    /*

    you can inherit one other class, and multiple interfaces
    you can create objects via; var jeff = new Person(...)

    */
    // has attributes
    private final Date bDay;
    private int age;
    public String name;

    // has a constructor
    public Person(Date bDay, int age, String name){
        this.bDay = bDay;
        this.age = age;
        this.name = name;
    }

    // has methods
    public int getAge(){
        return age;
    }
    // from abstract
    @Override
    public void speak(){
        IO.println("good morning!");
    }
    @Override
    public void move(){
        IO.println("I like to walk");
    }
    @Override
    public void eat(){
        IO.println("I need a knife and fork first");
    }

}
