package oop.lesson3.hw;

import java.io.Serializable;

public class Dog extends Pet implements PetInterface, Serializable {

    private int dogID;
    private int ownerDogID;

    @Override
    public String toString() {
        return "Dog{" +
                "dogID=" + dogID +
                ", ownerDogID=" + ownerDogID +
                ", name=" + getPetName() +
                "} " ;
    }

    public int getDogID() {
        return dogID;
    }

    public void setDogID(int dogID) {
        this.dogID = dogID;
    }

    public int getOwnerDogID() {
        return ownerDogID;
    }

    public void setOwnerDogID(int ownerDogID) {
        this.ownerDogID = ownerDogID;
    }

    public Dog(String petName, int ownerDogID) {
        super(petName);
        this.ownerDogID = ownerDogID;

    }

    public Dog(int dogID, int ownerDogID, String name) {
        super(name);
        this.dogID = dogID;
        this.ownerDogID = ownerDogID;
    }

    public Dog(int dogID) {
        this.dogID = dogID;
    }

    public void dogPlay() {
        System.out.println("Dog plays");
    }

    @Override
    void animalEats() {
        System.out.println("Dog eats");
    }

    public void animalDrinks() {
        System.out.println("Dog drink");
    }

    @Override
    public void run() {
        System.out.println("Dog runs");
    }
}
