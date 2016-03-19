/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * For example, Given n = 3, You should return the following matrix:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 *
 * Created by Yan on 2/14/16.
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int x1 = 0, y1 = 0;
        int x2 = n - 1, y2 = n - 1;
        int value = 1;
        while (x1 <= x2 && y1 <= y2) {
            for (int y = y1; y <= y2; y++)
                result[x1][y] = value++;
            for (int x = x1 + 1; x <= x2; x++)
                result[x][y2] = value++;
            for (int y = y2 - 1; y >= y1; y--)
                result[x2][y] = value++;
            for (int x = x2 - 1; x > x1; x--)
                result[x][y1] = value++;
            x1++; y1++;
            x2--; y2--;
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralMatrixII test = new SpiralMatrixII();
        for (int n = 1; n < 5; n++) {
            int[][] result = test.generateMatrix(n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(result[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
