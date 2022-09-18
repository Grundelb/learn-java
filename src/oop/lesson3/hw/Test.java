package oop.lesson3.hw;


public class Test {

    public static void main(String[] args) {

        Animal animal = new Dog(2,"Dunya");
        Dog dog = new Dog(2, "Gaechka");
        dog.setPetPaw(4);

        String str = String.format("Dog %s has - %d eyes, %d tail, %d paws. Count of pets is %d", dog.getPetName(), dog.getEyesCount(), dog.getPetTail(),dog.getPetPaw(), Animal.getCountAnimals());

        System.out.println(str);
    }

}
