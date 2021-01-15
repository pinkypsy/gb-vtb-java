package com.gb.lesson1.example;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = { new Dog("Bobik", 500, 10), new Cat("Barsik", 200),
                new Dog("Bobo", 300, 15), new Cat("Momo", 250) };
        for (Animal animal : animals) {
            animal.run(300);
            animal.swim(10);
        }

        System.out.println(Animal.getCounter());
        System.out.println(Dog.getCounter());
        System.out.println(Cat.getCounter());
    }
}
