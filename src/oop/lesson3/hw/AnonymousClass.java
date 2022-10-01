package oop.lesson3.hw;

public class AnonymousClass {

        public static void main(String[] args) {
            PetInterface pi = new PetInterface() {
                @Override
                public void run() {
                    PetInterface.super.run();
                }
            };

        }

}
