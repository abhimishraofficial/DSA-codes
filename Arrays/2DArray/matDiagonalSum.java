public class matDiagonalSum {

    // Function to calculate sum of diagonals
    public static int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += mat[i][i]; // Primary diagonal
            sum += mat[i][n - 1 - i]; // Secondary diagonal
        }

        // If the matrix has odd dimension, subtract the middle element (counted twice)
        if (n % 2 == 1) {
            sum -= mat[n / 2][n / 2];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int result = diagonalSum(matrix);
        System.out.println("Sum of diagonals: " + result); // Output: 25
    }
}
