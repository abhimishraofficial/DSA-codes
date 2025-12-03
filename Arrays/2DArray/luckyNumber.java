public class luckyNumber {

    public static int luckyNumber(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        // Step 1: Find min of each row and store their column index
        for (int i = 0; i < n; i++) {
            int rowMin = Integer.MAX_VALUE;
            int colIdx = -1;

            // find minimum in row
            for (int j = 0; j < m; j++) {
                if (mat[i][j] < rowMin) {
                    rowMin = mat[i][j];
                    colIdx = j;
                }
            }

            // Step 2: check if this rowMin is maximum in its column
            boolean isMaxInCol = true;
            for (int k = 0; k < n; k++) {
                if (mat[k][colIdx] > rowMin) {
                    isMaxInCol = false;
                    break;
                }
            }

            if (isMaxInCol) {
                return rowMin;   // this is the lucky number
            }
        }

        return -1; // if no lucky number exists
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {3, 7, 8},
            {9, 11, 13},
            {15, 16, 17}
        };

        System.out.println(luckyNumber(matrix));  // Output: 15
    }
}
