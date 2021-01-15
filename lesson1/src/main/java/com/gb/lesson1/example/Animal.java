package com.gb.lesson1.example;

public abstract class Animal {
    private String type;
    private String name;
     static int counter;
    private int maxRunDistance;
    private int maxSwimDistance;

    public Animal(String type, String name, int maxRunDistance,
            int maxSwimDistance) {
        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    void swim(int distance){
        if (distance <= maxSwimDistance){
            System.out.println(type + " " + name + " successfully swum " + distance + " m.");
        } else {
            System.out.println(type + " " + name + " could not swim " + distance +
                    " m.");
        }
    }
    void run(int distance){
        if (distance <= maxRunDistance){
            System.out.println(type + " " + name + " successfully run " + distance + " m.");
        } else {
            System.out.println(type + " " + name + " could not run " + distance + " m.");
        }
    }

}
