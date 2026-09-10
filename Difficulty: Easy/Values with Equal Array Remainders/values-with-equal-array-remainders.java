class Solution {

    public int sameMod(int[] arr) {

        int gcd = 0;

        // Find GCD of all differences
        for (int i = 1; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - arr[0]);
            gcd = findGCD(gcd, diff);
        }

        // If all elements are equal,
        // infinitely many k are possible
        if (gcd == 0) {
            return -1;
        }

        // Count the number of divisors of gcd
        int count = 0;

        for (int i = 1; i * i <= gcd; i++) {

            if (gcd % i == 0) {
                count++;

                // Count the paired divisor
                if (i != gcd / i) {
                    count++;
                }
            }
        }

        return count;
    }

    private int findGCD(int a, int b) {

        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}