package ogs.myInterest.inheritance;

public class Animals {

}

class Animal {


    void makeSound() {
        System.out.println("default animal");
    }
}

class Dog extends Animal {

    @Override
    void makeSound() {
        System.out.println("bark");
    }
}

class Cat extends Animal {

    @Override
    void makeSound() {
        System.out.println("meow");
    }

}
