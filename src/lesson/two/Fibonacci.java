package lesson.two;

public class Fibonacci {

    public static boolean isFibonacci(int x){
            int numberFibonacci = 1;
            int prevNumberFibonacci = 0;
            int newNumberFibonacci;

            do {

                newNumberFibonacci = prevNumberFibonacci + numberFibonacci;

                if (x == newNumberFibonacci){
                    return true;

                }

                prevNumberFibonacci = numberFibonacci;
                numberFibonacci = newNumberFibonacci;

            } while (x > newNumberFibonacci);

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isFibonacci(14));
    }

}
