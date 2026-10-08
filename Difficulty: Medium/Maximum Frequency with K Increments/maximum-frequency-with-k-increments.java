import java.util.*;

class Solution {
    public int maxFrequency(int[] arr, int k) {

        // Step 1: Sort the array
        Arrays.sort(arr);

        int left = 0;
        long sum = 0;
        int maxFreq = 1;

        // Step 2: Sliding window
        for (int right = 0; right < arr.length; right++) {

            sum += arr[right];

            // Cost to make every element in the window
            // equal to arr[right]
            long cost = (long) arr[right] * (right - left + 1) - sum;

            // If cost exceeds k, shrink the window
            while (cost > k) {
                sum -= arr[left];
                left++;

                cost = (long) arr[right] * (right - left + 1) - sum;
            }

            // Update maximum frequency
            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }
}