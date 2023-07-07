package ogs.myInterest.inheritance;

public class InheritanceExample {

    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal dog = new Dog();
        Animal cat = new Cat();
        Dog dog1 = (Dog) cat;//classcastexeption

        animal.makeSound();
        dog.makeSound();
        cat.makeSound();
        dog1.makeSound();

    }


}
