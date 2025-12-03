import java.util.Arrays;

public class MaxInRow {

    // Returns an array containing max element of each row
    public int[] maxInEachRow(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] result = new int[rows];

        for (int i = 0; i < rows; i++) {
            int maxVal = matrix[i][0];

            for (int j = 1; j < cols; j++) {
                maxVal = Math.max(maxVal, matrix[i][j]);
            }

            result[i] = maxVal;
        }

        return result;
    }

    // Test
    public static void main(String[] args) {

        MaxInRow obj = new MaxInRow();

        int[][] mat = {
            {1, 5, 3},
            {7, 2, 9},
            {4, 6, 8}
        };

        int[] ans = obj.maxInEachRow(mat);
        System.out.println(Arrays.toString(ans));
        // Output: [5, 9, 8]
    }
}
