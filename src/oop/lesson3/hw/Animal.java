package oop.lesson3.hw;



public class Animal {

    public Animal() {
        System.out.println("I am an animal");
        countAnimals++;
    }

    private static int countAnimals;

    public Animal(Dog dog) {
        countAnimals++;
    }

    public Animal(Pet pet) {
        countAnimals++;
    }


    public static int getCountAnimals() {
        return countAnimals;
    }


    private int eyesCount;

    public int getEyesCount() {
        return eyesCount;
    }

    public void setEyesCount(int eyesCount) {
        if (eyesCount >= 0) {
            this.eyesCount = eyesCount;
        }
    }

    void animalEats() {
        System.out.println("Animal eats");
    }

    void animalDrinks() {
        System.out.println("Animal drinks");
    }


}
