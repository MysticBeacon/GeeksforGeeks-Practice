class Solution {
    public int findMax(int n) {
        String s = String.valueOf(n);

        int ans = n;
        int maxSum = digitSum(n);

        for (int i = 0; i < s.length(); i++) {
            char[] arr = s.toCharArray();

            // Decrease the current digit by 1
            if (arr[i] == '0') {
                continue;
            }

            arr[i]--;

            // Make all digits after it 9
            for (int j = i + 1; j < arr.length; j++) {
                arr[j] = '9';
            }

            int candidate = Integer.parseInt(new String(arr));
            int sum = digitSum(candidate);

            if (sum > maxSum || (sum == maxSum && candidate > ans)) {
                maxSum = sum;
                ans = candidate;
            }
        }

        return ans;
    }

    private int digitSum(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}