import java.util.*;

class Solution {
    // Function to count subarrays with sum equal to 0.
    public long findSubarray(long[] arr, int n) {
        Map<Long, Integer> map = new HashMap<>();
        
        long prefixSum = 0;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];

            // If prefix sum itself is 0, it forms a valid subarray
            if (prefixSum == 0) {
                ans++;
            }

            // If prefixSum has appeared before, add its frequency
            if (map.containsKey(prefixSum)) {
                ans += map.get(prefixSum);
            }

            // Increase frequency of this prefixSum
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return ans;
    }
}

// Driver Code
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] arr = new long[n];
            
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }

            Solution ob = new Solution();
            System.out.println(ob.findSubarray(arr, n));
        }
        sc.close();
    }
}
