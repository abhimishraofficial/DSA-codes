import java.util.*;

class Solution {
    public int maxLen(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>(); // sum -> first index
        
        int sum = 0;
        int ans = 0;

        map.put(0, -1); // prefix sum 0 at index -1

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                ans = Math.max(ans, i - map.get(sum));
            } else {
                map.put(sum, i); // store first occurrence
            }
        }

        return ans;
    }
}

// Optional Main Class for testing
class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(sol.maxLen(arr, arr.length)); // Output: 5
    }
}
