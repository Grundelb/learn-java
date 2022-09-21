package oop.lesson3.hw;

public class Dog extends Pet implements PetInterface {

    public Dog(int eyesCount, String name){
        super(eyesCount);
        setPetName(name);
        System.out.println("Gauphh! I am a dog and my name is: " + name);
    }


    public Dog(int eyesCount) {
        super(eyesCount);
    }

    public void dogPlay(){
        System.out.println("Dog plays");
    }

    @Override
    void animalEats() {
        System.out.println("Dog eats");
    }

    public void animalDrinks(){
        System.out.println("Dog drink");
    }

    @Override
    public void run() {
        System.out.println("Dog runs");
    }
}
