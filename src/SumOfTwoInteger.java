/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * Example: Given a = 1 and b = 2, return 3.
 *
 * Created by Yan on 7/10/16.
 */
public class SumOfTwoInteger {
    public static int getSum(int a, int b) {
        int temp;
        while ((a & b) != 0) {
            temp = a;
            a = (a & b) << 1;
            b = temp ^ b;
        }
        return a ^ b;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println(i + " + " + j + " = " + getSum(i, j));

            }
        }
    }
}
