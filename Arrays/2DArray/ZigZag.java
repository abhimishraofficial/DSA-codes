import java.util.Arrays;

public class ZigZag {

    // Returns zigzag (diagonal) traversal of a matrix
    public int[] findDiagonalOrder(int[][] matrix) {

        if (matrix == null || matrix.length == 0) return new int[0];

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] result = new int[rows * cols];
        int k = 0;

        int row = 0, col = 0;
        boolean upward = true;

        while (row < rows && col < cols) {

            // If going upward
            if (upward) {
                while (row >= 0 && col < cols) {
                    result[k++] = matrix[row][col];
                    row--;
                    col++;
                }

                // Fix boundary after exiting loop
                if (col == cols) {     // hit right wall
                    col--;
                    row += 2;
                } else {               // hit top wall
                    row++;
                }

            } else { // going downward
                while (col >= 0 && row < rows) {
                    result[k++] = matrix[row][col];
                    row++;
                    col--;
                }

                // Fix boundary
                if (row == rows) {     // hit bottom
                    row--;
                    col += 2;
                } else {               // hit left wall
                    col++;
                }
            }

            // Flip direction
            upward = !upward;
        }

        return result;
    }

    // Test
    public static void main(String[] args) {
        ZigZag obj = new ZigZag();

        int[][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[] ans = obj.findDiagonalOrder(mat);

        System.out.println(Arrays.toString(ans));
        // Output → [1,2,4,7,5,3,6,8,9]
    }
}
