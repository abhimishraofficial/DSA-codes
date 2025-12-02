class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int consumed = numBottles;
        int extra = 0;

        while (numBottles >= numExchange) {
            numBottles -= (numExchange - 1);
            extra++;
        }
        return consumed + extra;
    }
}
