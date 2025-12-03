public class validMatrixSum {

    // Check if all row sums and column sums are equal
    public static boolean isValidMatrix(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return false;

        int m = matrix[0].length;

        int targetSum = 0;
        // Sum of first row
        for (int j = 0; j < m; j++) {
            targetSum += matrix[0][j];
        }

        // Check all rows
        for (int i = 1; i < n; i++) {
            int rowSum = 0;
            for (int j = 0; j < m; j++) {
                rowSum += matrix[i][j];
            }
            if (rowSum != targetSum) return false;
        }

        // Check all columns
        for (int j = 0; j < m; j++) {
            int colSum = 0;
            for (int i = 0; i < n; i++) {
                colSum += matrix[i][j];
            }
            if (colSum != targetSum) return false;
        }

        return true;
    }

    // Return sum of all elements if valid, else -1
    public static int validMatrixSum(int[][] matrix) {
        if (!isValidMatrix(matrix)) return -1;

        int totalSum = 0;
        for (int[] row : matrix) {
            for (int val : row) {
                totalSum += val;
            }
        }

        return totalSum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {2, 2, 2},
            {2, 2, 2},
            {2, 2, 2}
        };

        int sum = validMatrixSum(matrix);
        if (sum != -1) {
            System.out.println("Matrix is valid. Sum = " + sum);
        } else {
            System.out.println("Matrix is not valid.");
        }
    }
}
