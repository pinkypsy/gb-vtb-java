package com.gb.lesson1.example;

public class Dog extends Animal{
    private static int counter;

    public Dog(String name, int maxRunDistance,
            int maxSwimDistance) {
        super("Dog", name, maxRunDistance, maxSwimDistance);
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
}
