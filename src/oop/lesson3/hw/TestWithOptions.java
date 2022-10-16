package oop.lesson3.hw;

import java.io.Serializable;
import java.io.*;

public class TestWithOptions {

    public static void optionsDog(Dog dog) throws IOException {
//        Dog dogs;
        System.out.println("Please choose your option: \n1 to write file\n2 to read file \n3 to exit");
        int optionsInput;
        do {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                optionsInput = Integer.parseInt(reader.readLine());

                if (optionsInput == 1) {
                    try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("dog1.bin", true));) {
                        outputStream.writeObject(dog);
                    } catch (FileNotFoundException e) {
                        e.getStackTrace();
                    } catch (IOException e) {
                        e.getStackTrace();
                    }


                } else if (optionsInput == 2) {
                    try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("dog1.bin"));) {
//                        dogs = (Dog) inputStream.readObject();
                        System.out.println(inputStream.readObject());


                    } catch (FileNotFoundException e) {
                        e.getStackTrace();
                    } catch (IOException e) {
                        e.getStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.getStackTrace();
                    }

                } else if (optionsInput == 3) {
                    break;
                } else {
                    System.out.println("Wrong input!");
                }


        } while (true);
    }

    public static void main(String[] args) throws IOException {
        Dog dog = new Dog(2, "Gaechka");
        optionsDog(dog);
    }


}
