
class Solution {
    static final long MOD = 1000000007L;

    public int subsequenceSum(String s) {
        long sum = 0;

        for (int i = 0; i < s.length(); i++) {
            sum = (sum + (s.charAt(i) - '0')) % MOD;
        }

        long power = 1;
        long base = 2;
        long exp = s.length() - 1;

        // Binary exponentiation
        while (exp > 0) {
            if (exp % 2 == 1) {
                power = (power * base) % MOD;
            }

            base = (base * base) % MOD;
            exp /= 2;
        }

        return (int) ((sum * power) % MOD);
    }
}
