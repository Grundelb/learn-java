package oop.lesson3.hw;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public abstract class Pet extends Animal implements Serializable {

    public Pet() {

    }

    ;

    public Pet(int eyesCount) {
        setEyesCount(eyesCount);
        System.out.println("I am a pet");
    }

    public Pet(String petName) {
        this.petName = petName;
    }

    ;

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

    public String getPetName() {
        return petName;
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


    public static class PetOwner {

        private int idOwner;
        private String ownerName;
        private String ownerEmail;
        private java.sql.Date registrationDate;

        public PetOwner(int idOwner, String ownerName, String ownerEmail, Date registrationDate) {
            this.idOwner = idOwner;
            this.ownerName = ownerName;
            this.ownerEmail = ownerEmail;
            this.registrationDate = (java.sql.Date) registrationDate;
        }

        public PetOwner(String ownerName, String ownerEmail) {
            this.ownerName = ownerName;
            this.ownerEmail = ownerEmail;
        }

        public PetOwner(int idOwner, String ownerName) {
            this.idOwner = idOwner;
            this.ownerName = ownerName;
        }

        @Override
        public String toString() {
            return "PetOwner{" +
                    "idOwner=" + idOwner +
                    ", ownerName='" + ownerName + '\'' +
                    ", ownerEmail='" + ownerEmail + '\'' +
                    ", registrationDate=" + registrationDate +
                    '}';
        }

        public int getIdOwner() {
            return idOwner;
        }

        public String getOwnerName() {
            return ownerName;
        }

        public void setOwnerName(String ownerName) {
            this.ownerName = ownerName;
        }

        public String getOwnerEmail() {
            return ownerEmail;
        }

        public void setOwnerEmail(String ownerEmail) {
            this.ownerEmail = ownerEmail;
        }

        public Date getRegistrationDate() {
            return  registrationDate;
        }

        public void setRegistrationDate(Date registrationDate) {
            this.registrationDate = (java.sql.Date) registrationDate;
        }
    }

}

