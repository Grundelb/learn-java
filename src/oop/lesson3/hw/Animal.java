package oop.lesson3.hw;
import java.io.Serializable;
import java.util.Objects;


public abstract class Animal implements Serializable {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return getEyesCount() == animal.getEyesCount();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEyesCount());
    }

    @Override
    public String toString() {
        return "Animal{" +
                "eyesCount=" + eyesCount +
                '}';
    }

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
