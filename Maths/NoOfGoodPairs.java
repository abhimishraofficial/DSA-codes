import java.util.*;

class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        // Count frequency
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        int count = 0;
        
        // Calculate pairs using formula x * (x - 1) / 2
        for (int val : freq.values()) {
            if (val > 1) {
                count += (val * (val - 1)) / 2;
            }
        }
        
        return count;
    }
}
