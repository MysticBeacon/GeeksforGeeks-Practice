
class Solution {
    public char posInfinite(String s, int pos) {

        long[] len = new long[64];

        len[0] = s.length();

        int k = 0;

        // Calculate the length after each expansion
        while (len[k] < pos) {
            k++;
            len[k] = 2 * len[k - 1] + k;
        }

        long p = pos;

        // Trace the position backwards
        while (k > 0) {

            long prevLen = len[k - 1];
            long dollarEnd = prevLen + k;

            // Position belongs to '$' section
            if (p > prevLen && p <= dollarEnd) {
                return '$';
            }

            // Position belongs to reversed section
            if (p > dollarEnd) {
                p = len[k] - p + 1;
            }

            k--;
        }

        return s.charAt((int) p - 1);
    }
}
