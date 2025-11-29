import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    static final int MOD = 1000000007;

    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> list = new ArrayList<>();

        // Generate all subarray sums
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                list.add(sum);
            }
        }

        // Sort the list
        Collections.sort(list);

        long total = 0;

        // Sum elements from left-1 to right-1
        for (int i = left - 1; i <= right - 1; i++) {
            total = (total + list.get(i)) % MOD;
        }

        return (int)(total % MOD);
    }
}

// Optional Testing
class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1,2,3,4};
        System.out.println(sol.rangeSum(nums, nums.length, 1, 5)); // Output: 13
    }
}
