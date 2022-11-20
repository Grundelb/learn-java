package oop.lesson3.hw;

import java.io.*;
import java.util.*;

    public class TestWithOptions {
    static int optionsInput;
    private static int dogsNumber = 1;
    static Map<Integer, Dog> dogsStore = new HashMap<>();

    public static void optionWriteDog(Dog dog) throws IOException {

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("dog1.bin", true));) {
            outputStream.writeObject(dog);
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        }

    }

    public static void optionReadDog(Dog dog) throws IOException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("dog1.bin"));) {

            System.out.println(inputStream.readObject());


        } catch (FileNotFoundException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        } catch (ClassNotFoundException e) {
            e.getStackTrace();
            System.out.println("File is not found.");
        }

    }

    public static void optionAddNewDog() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Dog dog = new Dog("2", 5);

        try {
            System.out.println("Please enter pet's name: ");
            String inputDogName = reader.readLine();
            dog.setPetName(inputDogName);


        } catch (InputMismatchException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        }
        dogsStore.put(dogsNumber, dog);
        dogsNumber++;
    }

    public static void optionRemoveDog() {

        int dogNumberValue = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            dogNumberValue = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (dogsStore.containsKey(dogNumberValue)) {
            dogsStore.remove(dogNumberValue);
        } else {
            System.out.println("Number is absent");
        }

    }

    public static void optionShowDogs() {
        ArrayList<Dog> values = new ArrayList<>(dogsStore.values());
        System.out.println("Your dogs: " + values);
    }

    public static void optionUpdateDog(int dogNumberValue, Dog dog) {
        if (dogsStore.containsKey(dogNumberValue)) {

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
                System.out.println("Please enter new pet's name: ");
                String inputDogName = reader.readLine();
                dog.setPetName(inputDogName);
                dogsStore.put(dogNumberValue, dog);


            } catch (InputMismatchException e) {
                e.getStackTrace();
            } catch (IOException e) {
                e.getStackTrace();
            }

        } else {
            System.out.println("Number is absent");
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Dog dog1 = new Dog("2", 33);

        try {
            System.out.println("Please enter pet's name: ");
            String inputDogName = reader.readLine();
            dog1.setPetName(inputDogName);


        } catch (InputMismatchException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        }

        System.out.println("Please choose your option: \n1 to write file\n2 to read file \n3 to add new dog"
                + "\n4 to add remove dog \n5 to show all dogs \n6 to update your dog \n7 exit");
        try {
            optionsInput = Integer.parseInt(reader.readLine());

            switch (optionsInput) {
                case 1:
                    optionWriteDog(dog1);
                    break;
                case 2:
                    optionReadDog(dog1);
                    break;
                case 3:
                    optionAddNewDog();
                    break;
                case 4:
                    optionRemoveDog();
                    break;
                case 5:
                    optionShowDogs();
                    break;
                case 6:
                    optionUpdateDog(1, dog1);
                    break;
                case 7:
                    System.out.println("Exit");
                    break;
                default:
                    throw new MismatchInputException("Wrong input!");
            }


        } catch (InputMismatchException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        } catch (MismatchInputException e) {
            throw new RuntimeException(e);
        }

        reader.close();
    }


}

class MismatchInputException extends Exception {
    MismatchInputException(String message) {
        super(message);
    }
}