public class magicSquaresInGrid {

    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        // Only 3x3 subgrids can be magic
        for (int i = 0; i + 2 < n; i++) {
            for (int j = 0; j + 2 < m; j++) {
                if (isMagic(grid, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isMagic(int[][] g, int r, int c) {

        // center of a 3x3 magic square must be 5
        if (g[r+1][c+1] != 5) return false; 

        // frequency array for digits 1 to 9
        boolean[] seen = new boolean[10];

        // check all values are 1-9 and no repeats
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                int val = g[i][j];
                if (val < 1 || val > 9 || seen[val]) return false;
                seen[val] = true;
            }
        }

        // check all rows sum to 15
        for (int i = 0; i < 3; i++) {
            if (g[r+i][c] + g[r+i][c+1] + g[r+i][c+2] != 15)
                return false;
        }

        // check all columns sum to 15
        for (int j = 0; j < 3; j++) {
            if (g[r][c+j] + g[r+1][c+j] + g[r+2][c+j] != 15)
                return false;
        }

        // check diagonals
        if (g[r][c] + g[r+1][c+1] + g[r+2][c+2] != 15) return false;
        if (g[r][c+2] + g[r+1][c+1] + g[r+2][c] != 15) return false;

        return true;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 3, 8, 4},
            {9, 5, 1, 9},
            {2, 7, 6, 2}
        };

        magicSquaresInGrid obj = new magicSquaresInGrid();
        System.out.println(obj.numMagicSquaresInside(grid)); // Output: 1
    }
}
