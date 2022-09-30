package oop.lesson3.hw;



public abstract class Animal {

    public Animal(){
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

    abstract void animalEats();

    abstract void animalDrinks();



}
