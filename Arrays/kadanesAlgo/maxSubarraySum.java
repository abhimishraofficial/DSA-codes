class Solution {
    public int maxSubArray(int[] nums) {

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];
            maxSum = Math.max(maxSum, sum);

            if (sum < 0) {
                sum = 0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {

        Solution obj = new Solution();

        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int result = obj.maxSubArray(arr);

        System.out.println("Maximum Subarray Sum = " + result);
    }
}