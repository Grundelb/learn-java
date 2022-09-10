package lesson.two;

public class PalindromeNumber {

    static boolean isPalindromeNumber(int a) {
        String str1 = Integer.toString(a);
        String str2 = new StringBuilder().append(a).reverse().toString();


        if (str1.equals(str2))
            return true;

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeNumber(345543));
    }
}
