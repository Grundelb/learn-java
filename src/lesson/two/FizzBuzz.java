package lesson.two;

public class FizzBuzz {
    public static void getFizzBuzz(int yourNumber) {
        if (yourNumber % 3 == 0 && yourNumber % 5 == 0) {
            System.out.println("fizz-buzz");
        } else if (yourNumber % 3 == 0) {
            System.out.println("fizz");
        } else if (yourNumber % 5 == 0) {
            System.out.println("buzz");
        }
    }

    public static void main(String[] args) {

        getFizzBuzz(33);
        getFizzBuzz(55);
        getFizzBuzz(60);
       // getFizzBuzz(0);
        getFizzBuzz(-15);
        getFizzBuzz(198);
        getFizzBuzz(5);
    }

}
