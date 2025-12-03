import java.util.*;

public class diagonalTraverse2 {

    // Diagonal Traverse II (handles variable row sizes)
    public int[] findDiagonalOrder(List<List<Integer>> nums) {

        // Map: diagonalIndex = row + col → list of values
        Map<Integer, List<int[]>> map = new HashMap<>();
        int total = 0;
        int maxDiagonal = 0;

        // Store (row, value) because sorting by row matters
        for (int r = 0; r < nums.size(); r++) {
            for (int c = 0; c < nums.get(r).size(); c++) {
                int diag = r + c;
                map.putIfAbsent(diag, new ArrayList<>());
                map.get(diag).add(new int[]{r, nums.get(r).get(c)});
                total++;
                maxDiagonal = Math.max(maxDiagonal, diag);
            }
        }

        int[] result = new int[total];
        int idx = 0;

        // Traverse diagonals in sorted order
        for (int d = 0; d <= maxDiagonal; d++) {
            if (!map.containsKey(d)) continue;

            // Sort by row descending → because bottom-most first
            List<int[]> list = map.get(d);
            list.sort((a, b) -> b[0] - a[0]);

            // Add values
            for (int[] pair : list) {
                result[idx++] = pair[1];
            }
        }

        return result;
    }

    // Test
    public static void main(String[] args) {
        diagonalTraverse2 obj = new diagonalTraverse2();

        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(1, 2, 3));
        nums.add(Arrays.asList(4, 5, 6));
        nums.add(Arrays.asList(7, 8));
        nums.add(Arrays.asList(9));

        int[] ans = obj.findDiagonalOrder(nums);
        System.out.println(Arrays.toString(ans));
        // Output: [1,4,2,7,5,3,9,8,6]
    }
}
