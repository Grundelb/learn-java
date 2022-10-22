package oop.lesson3.hw;

import java.io.Serializable;
import java.util.Objects;

public abstract class Pet extends Animal implements Serializable {

    public Pet(int eyesCount) {
        setEyesCount(eyesCount);
        System.out.println("I am a pet");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        if (!super.equals(o)) return false;
        Pet pet = (Pet) o;
        return getPetTail() == pet.getPetTail() && getPetPaw() == pet.getPetPaw() && getPetName().equals(pet.getPetName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPetName(), getPetTail(), getPetPaw());
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petName='" + petName + '\'' +
                ", petTail=" + petTail +
                ", petPaw=" + petPaw +
                '}';
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

    static class PetOwner{

        String ownerName;
        String ownerLastName;
        String ownerPetName;

        public PetOwner(String ownerName, String ownerLastName, String ownerPetName) {
            this.ownerName = ownerName;
            this.ownerLastName = ownerLastName;
            this.ownerPetName = ownerPetName;
        }

    }


}
