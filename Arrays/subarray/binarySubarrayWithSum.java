import java.util.*;

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        
        map.put(0, 1); // prefix sum = 0 occurs once
        
        int sum = 0;
        int count = 0;
        
        for (int num : nums) {
            sum += num;

            int find = sum - goal;

            if (map.containsKey(find)) {
                count += map.get(find);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}

// OPTIONAL DRIVER CODE if needed
class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1,0,1,0,1};
        int goal = 2;
        System.out.println(sol.numSubarraysWithSum(nums, goal)); // Output: 4
    }
}
