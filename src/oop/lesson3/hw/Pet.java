package oop.lesson3.hw;

public class Pet extends Animal {

    public Pet(int eyesCount) {
        setEyesCount(eyesCount);
        System.out.println("I am a pet");
    }

    private String petName;

    public StringBuilder getPetName() {
        StringBuilder sbPetName = new StringBuilder(this.petName);
        return sbPetName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    private final int petTail = 1;

    public int getPetTail() {
        return petTail;
    }

    private int petPaw = 4;

    public int getPetPaw() {
        return petPaw;
    }

    public void setPetPaw(int petPaw) {
        if (petPaw >= 0 && petPaw <= 4) {
            this.petPaw = petPaw;
        }
    }

    public void run() {
        System.out.println("Pet runs");
    }


}