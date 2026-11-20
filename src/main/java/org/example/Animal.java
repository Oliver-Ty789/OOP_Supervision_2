package org.example;

public abstract class Animal implements Movement {
    /*

    this class cannot be instantiated, can be inherited.

    */
    private int legs;
    private String species;

    // most animals can speak
    abstract void speak();

}
