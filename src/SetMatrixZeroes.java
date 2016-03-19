import java.util.Arrays;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * Created by Yan on 2/21/16.
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int setFirstColumn = 1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0)
                setFirstColumn = 0;
            for (int j = 1; j < matrix[0].length; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 1; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if (setFirstColumn == 0)
                matrix[i][0] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {0, 1, 2},
        };

        SetMatrixZeroes test = new SetMatrixZeroes();
        test.setZeroes(matrix);
        for (int[] arr : matrix)
            System.out.println(Arrays.toString(arr));
    }
}
