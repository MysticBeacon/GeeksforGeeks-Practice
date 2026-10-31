
class Solution {
    public int maximumSubarray(int[] arr) {

        int noSquare = arr[0];
        int oneSquare = arr[0] * arr[0];

        int ans = Math.max(noSquare, oneSquare);

        for (int i = 1; i < arr.length; i++) {

            int curr = arr[i];
            int square = curr * curr;

            int prevNoSquare = noSquare;

            // Maximum sum without squaring
            noSquare = Math.max(curr, noSquare + curr);

            // Maximum sum with one element squared
            oneSquare = Math.max(
                square,
                Math.max(
                    prevNoSquare + square,
                    oneSquare + curr
                )
            );

            ans = Math.max(ans, Math.max(noSquare, oneSquare));
        }

        return ans;
    }
}
