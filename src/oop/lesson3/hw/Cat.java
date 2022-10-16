package oop.lesson3.hw;

import java.io.Serializable;

public class Cat extends Pet implements PetInterface, Serializable {

    public Cat(int eyesCount) {
        super(eyesCount);
        System.out.println("Meow! I'm a cat");
    }

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

    public class CatFood{
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
