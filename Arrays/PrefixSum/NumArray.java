public class NumArray {
    private int[] prefix;

    public NumArray(int[] nums) {
        prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left > 0) return prefix[right] - prefix[left - 1];
        return prefix[right];
    }

    // ⭐ ADD THIS MAIN METHOD ⭐
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5}; // Example input array
        NumArray obj = new NumArray(input);
        
        // Example usage: sum of indices 1 through 3 (2 + 3 + 4 = 9)
        int result = obj.sumRange(1, 3); 
        System.out.println("The sum is: " + result); // Should print 9
    }
}