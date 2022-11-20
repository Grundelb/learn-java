package oop.lesson3.hw;

import java.io.Serializable;

public class Cat extends Pet implements PetInterface, Serializable {

    public Cat(int eyesCount) {
        super(eyesCount);
        System.out.println("Meow! I'm a cat");
    }

    public Cat(int catID, int ownerID, String petName) {
        super(petName);
        this.catID = catID;
        this.ownerID = ownerID;
    }

    public Cat(int catID, int ownerID) {
        this.catID  = catID;
        this.ownerID = ownerID;
    }

    public Cat(String petName, int ownerID) {
        super(petName);
        this.ownerID = ownerID;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "catID=" + catID +
                ", ownerID=" + ownerID +
                ", name=" + getPetName() +
                '}';
    }

    public int getCatID() {
        return catID;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }

    private int catID;
    private int ownerID;

    @Override
    void animalEats() {

    }

    @Override
    void animalDrinks() {
        System.out.println("Cat drinks milk!");
    }

    @Override
    public void run() {
        PetInterface.super.run();
    }

    public class CatFood {
        String dryFood;
        String WetFood;

        public String getDryFood() {
            return dryFood;
        }

        public void setDryFood(String dryFood) {
            this.dryFood = dryFood;
        }

        public String getWetFood() {
            return WetFood;
        }

        public void setWetFood(String wetFood) {
            WetFood = wetFood;
        }
    }


}
