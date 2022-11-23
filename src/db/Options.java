package db;

import oop.lesson3.hw.*;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.sql.*;

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

            petOwner = new Pet.PetOwner(name, ownerEmail);
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

    public void getJoinStatment() {
        JoinOwnerDao joinOwnerDao = new JoinOwnerDao();
        joinOwnerDao.getAll().stream().forEach(System.out::println);
    }

    public void getOwnerIdSortedByMin() {
        CountofRows cr = new CountofRows();
        cr.getAll().stream().forEach(System.out::println);
    }

    public void getTotalCountOfRows() {
        CountofRows cr = new CountofRows();
        System.out.println(cr.getCount());
    }

    public void getOwnersInRangeOfDateRegistration() {
        try (Scanner sc = new Scanner(System.in);) {

            OwnerDao petOwner = new OwnerDao();

            System.out.println("Enter first date in format YYYY-MM-DD");
            String firstDate = sc.nextLine();
            Date firstDateSQL = Date.valueOf(firstDate);

            System.out.println("Enter first date in format YYYY-MM-DD");
            String secondDate = sc.nextLine();
            Date secondDateSQL = Date.valueOf(secondDate);

            petOwner.getAll(firstDateSQL, secondDateSQL).stream().forEach(System.out::println);

        } catch (InputMismatchException e) {
            System.out.println("Wrong input!");
        }
    }


    public void menu() {
        try (
                Scanner sc = new Scanner(System.in);) {
            System.out.println("Please choose your option: \n1 to add owner" +
                    "\n2 to add dog " +
                    "\n3 to add cat " +
                    "\n4 to update cat " +
                    "\n5 to delete dog " +
                    "\n6 to delete all dogs " +
                    "\n7 to show all owners, dogs and cats" +
                    "\n8 to get total count of rows" +
                    "\n9 to get owners sorted by id " +
                    "\n10 to find cat by name" +
                    "\n11 to get owners by date range");
            int inputNumber = sc.nextInt();
            switch (inputNumber) {
                case 1:
                    addOwner();
                    break;
                case 2:
                    addDod();
                    break;
                case 3:
                    addCat();
                    break;
                case 4:
                    updateCat();
                    break;
                case 5:
                    deleteDog();
                    break;
                case 6:
                    deleteAllDogs();
                    break;
                case 7:
                    getJoinStatment();
                    break;
                case 8:
                    getTotalCountOfRows();
                    break;
                case 9:
                    getOwnerIdSortedByMin();
                    break;
                case 10:
                    getCatByName();
                    break;
                case 11:
                    getOwnersInRangeOfDateRegistration();
                    break;
                default:
                    System.out.println("There is no such option");
            }
        } catch (InputMismatchException e) {
            System.out.println("Wrong input!");
        }
    }

}
