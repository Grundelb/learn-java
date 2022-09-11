package lesson.two;

public class SqrtX {
    public static int mySqrt(int x) {
        if (x > 0) {
            for (int y = 0; y <= x; y++) {

                if (y * y == x) {
                    return y;
                } else if (y * y > x) {
                    return y - 1;
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(mySqrt(45367));
    }

}
