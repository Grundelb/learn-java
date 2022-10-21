package oop.lesson3.hw;

import java.io.*;
import java.util.InputMismatchException;

public class TestWithOptions {
    static int optionsInput;

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


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Dog dog = new Dog(2, null);
        try  {
            System.out.println("Please enter pet's name: ");
            String inputDogName = reader.readLine();
            dog.setPetName(inputDogName);

        } catch (InputMismatchException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        }


        System.out.println("Please choose your option: \n1 to write file\n2 to read file \n3 to exit");
        try {
            optionsInput = Integer.parseInt(reader.readLine());

            if (optionsInput == 1) {
                optionWriteDog(dog);
            } else if (optionsInput == 2) {
                optionReadDog(dog);
            } else if (optionsInput == 3) {
                System.out.println("exit");
            } else {throw new MismatchInputException("Wrong input!");}

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
    MismatchInputException(String message){
        super(message);
    }
}