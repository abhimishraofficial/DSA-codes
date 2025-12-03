public class spiralMatrix4 {

    public static int[][] generateCounterClockwise(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1;
        int top = 0, bottom = n - 1;
        int num = 1;

        while (left <= right && top <= bottom) {
            // Fill left column
            for (int i = top; i <= bottom; i++) {
                matrix[i][left] = num++;
            }
            left++;

            // Fill bottom row
            for (int i = left; i <= right; i++) {
                matrix[bottom][i] = num++;
            }
            bottom--;

            // Fill right column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][right] = num++;
                }
                right--;
            }

            // Fill top row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[top][i] = num++;
                }
                top++;
            }
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] result = generateCounterClockwise(n);
        printMatrix(result);
    }
}
