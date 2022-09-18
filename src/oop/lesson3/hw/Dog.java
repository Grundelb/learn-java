package oop.lesson3.hw;

public class Dog extends Pet {

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

}
