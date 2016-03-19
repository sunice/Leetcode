import java.util.Arrays;

/**
 * You are given an n x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).
 * Follow up: Could you do this in-place?
 *
 * Created by Yan on 2/21/16.
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        int start = 0, end = n;
        while (start < end) {
            for (int i = start; i < end; i++) {
                int temp = matrix[start][i];
                matrix[start][i] = matrix[n - i][start];
                matrix[n - i][start] = matrix[n - start][n - i];
                matrix[n - start][n - i] = matrix[i][n - start];
                matrix[i][n - start] = temp;
            }
            start++;
            end--;
        }
    }

    public void rotateII(int[][] matrix) {
        int n = matrix.length - 1;
        for (int i = 0; i <= n / 2; i++)
            for (int j = 0;j <= (n - 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j][i];
                matrix[n - j][i] = matrix[n - i][n - j];
                matrix[n - i][n - j] = matrix[j][n - i];
                matrix[j][n - i] = temp;
            }
    }

    public static void main(String[] args) {
        int size = 5;
        int[][] matrix = new int[size][size];
        RotateImage test = new RotateImage();
        for (int i = 0; i < size; i++)
            for (int j = 0;j < size; j++)
                matrix[i][j] = i * size + j;
        for (int[] arr : matrix)
            System.out.println(Arrays.toString(arr));
        System.out.println();
        test.rotateII(matrix);
        for (int[] arr : matrix)
            System.out.println(Arrays.toString(arr));
    }
}
