public class diagonalSum {

    // Returns the sum of primary + secondary diagonals
    public int diagonalSum(int[][] matrix) {
        int n = matrix.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            // Primary diagonal (i, i)
            sum += matrix[i][i];

            // Secondary diagonal (i, n - 1 - i)
            sum += matrix[i][n - 1 - i];
        }

        // If n is odd, middle element is added twice → subtract once
        if (n % 2 == 1) {
            sum -= matrix[n / 2][n / 2];
        }

        return sum;
    }

    // Test the code
    public static void main(String[] args) {
        diagonalSum obj = new diagonalSum();

        int[][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println(obj.diagonalSum(mat)); 
        // Output: 1 + 5 + 9 + 3 + 5 + 7 = 30 → minus middle 5 = 25
    }
}
