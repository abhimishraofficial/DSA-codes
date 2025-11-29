import java.util.*;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            while (sum >= target) {
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return (ans == Integer.MAX_VALUE) ? 0 : ans;
    }
}

// Optional Test Main
class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(sol.minSubArrayLen(target, nums)); // Output: 2
    }
}
