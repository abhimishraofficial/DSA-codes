public class SearchIN2dMat {

    // Searches for a target value inside the matrix
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = 0;
        int high = rows * cols - 1;

        // Binary search on the flattened matrix
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Convert 1D index -> 2D index
            int row = mid / cols;
            int col = mid % cols;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false; // Not found
    }

    // Optional test
    public static void main(String[] args) {
        SearchIN2dMat obj = new SearchIN2dMat();

        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        System.out.println(obj.searchMatrix(matrix, 3));  // true
        System.out.println(obj.searchMatrix(matrix, 13)); // false
    }
}
