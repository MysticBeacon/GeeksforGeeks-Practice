
import java.util.*;

class Solution {
    public int longestSubarrayDivK(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        long prefixSum = 0;
        int maxLength = 0;

        map.put(0, -1);

        for (int i = 0; i < arr.length; i++) {

            prefixSum += arr[i];

            // Handle negative numbers
            int rem = (int)(((prefixSum % k) + k) % k);

            if (map.containsKey(rem)) {

                int len = i - map.get(rem);

                maxLength = Math.max(maxLength, len);

            } else {

                map.put(rem, i);
            }
        }

        return maxLength;
    }
}
