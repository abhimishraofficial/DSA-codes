import java.util.ArrayList;
import java.util.List;

public class diagonalTravesal {

    // Diagonal traversal of a matrix (not zigzag)
    public List<List<Integer>> diagonalTraversal(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        List<List<Integer>> result = new ArrayList<>();

        // Total diagonals = n + m - 1
        for (int d = 0; d < n + m - 1; d++) {
            List<Integer> diag = new ArrayList<>();

            // Start row = max(0, d - m + 1)
            int rowStart = Math.max(0, d - m + 1);
            // End row = min(n-1, d)
            int rowEnd = Math.min(n - 1, d);

            for (int row = rowStart; row <= rowEnd; row++) {
                int col = d - row;
                diag.add(matrix[row][col]);
            }

            result.add(diag);
        }

        return result;
    }

    // Test
    public static void main(String[] args) {
        diagonalTravesal obj = new diagonalTravesal();

        int[][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        List<List<Integer>> ans = obj.diagonalTraversal(mat);

        for (List<Integer> diag : ans) {
            System.out.println(diag);
        }

        /*
        Output:
        [1]
        [2, 4]
        [3, 5, 7]
        [6, 8]
        [9]
        */
    }
}
