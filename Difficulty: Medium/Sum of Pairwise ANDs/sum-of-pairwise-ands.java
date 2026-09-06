class Solution {
    public long pairAndSum(int[] arr) {
        long ans = 0;

        // arr[i] <= 10^8, so 31 bits are enough
        for (int bit = 0; bit < 31; bit++) {
            long count = 0;

            // Count numbers having this bit set
            for (int num : arr) {
                if ((num & (1 << bit)) != 0) {
                    count++;
                }
            }

            // Number of pairs having this bit set in AND
            long pairs = count * (count - 1) / 2;

            // Add contribution of this bit
            ans += pairs * (1L << bit);
        }

        return ans;
    }
}