class Solution {

    public int addDigits(int num) {

        while (num > 9) {

            int sum = 0;

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            num = sum;
        }

        return num;
    }

    public static void main(String[] args) {

        Solution obj = new Solution();

        int result = obj.addDigits(38);

        System.out.println("Answer = " + result);
    }
}