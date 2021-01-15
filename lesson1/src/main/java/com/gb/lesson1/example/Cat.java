package com.gb.lesson1.example;

public class Cat extends Animal {

    private static int counter;

    public Cat(String name, int maxRunDistance) {
        super("Cat", name, maxRunDistance, 0);
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
}
