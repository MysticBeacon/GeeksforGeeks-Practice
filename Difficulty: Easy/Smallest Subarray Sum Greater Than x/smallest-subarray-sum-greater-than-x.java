
class Solution {
    public int smallestSubWithSum(int[] arr, int x) {
        int n = arr.length;

        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > x) {
                minLength = Math.min(minLength, right - left + 1);

                sum -= arr[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
