package oop.lesson3.hw;

public class TestNestedClass {

    public static void main(String[] args) {
        Cat cat1 = new Cat(2);
        Cat.CatFood catFood = cat1.new CatFood();
        catFood.setDryFood("whiskas");
    }



}

