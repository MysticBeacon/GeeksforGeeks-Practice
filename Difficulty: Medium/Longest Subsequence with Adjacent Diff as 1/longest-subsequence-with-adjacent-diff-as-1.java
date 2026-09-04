import java.util.*;

class Solution {
    public int longestSubseq(int[] arr) {
        HashMap<Integer, Integer> dp = new HashMap<>();

        int ans = 1;

        for (int x : arr) {
            int prev1 = dp.getOrDefault(x - 1, 0);
            int prev2 = dp.getOrDefault(x + 1, 0);

            int current = Math.max(prev1, prev2) + 1;

            dp.put(x, Math.max(dp.getOrDefault(x, 0), current));

            ans = Math.max(ans, dp.get(x));
        }

        return ans;
    }
}