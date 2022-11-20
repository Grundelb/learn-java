package db;

import oop.lesson3.hw.*;

import java.io.IOException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Options {

    public void addCat() {

        try (Scanner sc = new Scanner(System.in);) {

            Cat cat = null;
            CatDao catDao = null;

            System.out.println("Enter name: ");
            String name = sc.nextLine();

            System.out.println("Enter owner id: ");
            int ownerId = sc.nextInt();

            cat = new Cat(name, ownerId);
            catDao = new CatDao();

            catDao.add(cat);

        } catch (InputMismatchException e) {
            System.out.println("Wrong input!");
        }


    }

    public void addDod() {

        try (Scanner sc = new Scanner(System.in);) {

            Dog dog = null;
            DogDao dogDao = null;

            System.out.println("Enter name: ");
            String name = sc.nextLine();

            System.out.println("Enter owner id: ");
            int ownerId = sc.nextInt();

            dog = new Dog(name, ownerId);
            dogDao = new DogDao();

            dogDao.add(dog);

        } catch (InputMismatchException e) {
            System.out.println("Wrong input!");
        }

    }

    public void addOwner() {

        try (Scanner sc = new Scanner(System.in);) {

            Pet.PetOwner petOwner = null;
            OwnerDao ownerDao = null;

            System.out.println("Enter name: ");
            String name = sc.nextLine();

            System.out.println("Enter email: ");
            String ownerEmail = sc.nextLine();

            System.out.println("Enter registration year: ");
            int year = sc.nextInt();
            System.out.println("Enter registration month: ");
            int month = sc.nextInt();
            System.out.println("Enter registration day: ");
            int day = sc.nextInt();
            Date regDate = new Date(year, day, month);


            petOwner = new Pet.PetOwner(name, ownerEmail, regDate);
            ownerDao = new OwnerDao();

            ownerDao.add(petOwner);

        } catch (InputMismatchException e) {
            System.out.println("Wrong input!");
        }

    }

    public void updateCat() {
        try (Scanner sc = new Scanner(System.in);) {

            Cat cat = null;
            CatDao catDao = null;

            System.out.println("Enter cat id: ");
            int catId = sc.nextInt();

            System.out.println("Enter owner id: ");
            int ownerId = sc.nextInt();

            cat = new Cat(catId, ownerId);
            catDao = new CatDao();

            catDao.update(cat);

        } catch (InputMismatchException e) {
            System.out.println("Wrong input!");
        }
    }

    public void deleteAllDogs() {
        DogDao dogDao = new DogDao();
        dogDao.delete();
    }

    public void deleteDog() {
        try (Scanner sc = new Scanner(System.in);) {

            Dog dog = null;
            DogDao dogDao = new DogDao();

            System.out.println("Enter dog id: ");
            int dogId = sc.nextInt();

            dog = new Dog(dogId);
            dogDao.delete(dog);

        } catch (InputMismatchException e) {
            System.out.println("Wrong input!");
        }
    }

    public void getCatByName() {
        try (Scanner sc = new Scanner(System.in);) {

            CatDao catDao = null;

            System.out.println("Enter cat name: ");
            String catName = sc.nextLine();

            catDao = new CatDao();

            System.out.println(catDao.get(catName));

        } catch (InputMismatchException e) {
            System.out.println("Wrong input!");
        }
    }

}
