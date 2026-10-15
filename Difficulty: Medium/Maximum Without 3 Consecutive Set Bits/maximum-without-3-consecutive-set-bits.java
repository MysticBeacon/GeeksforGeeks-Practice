
class Solution {
    public int maxValue(int n) {
        while ((n & (n >> 1) & (n >> 2)) != 0) {
            int bits = n & (n >> 1) & (n >> 2);
            int pos = 31 - Integer.numberOfLeadingZeros(bits);
            n &= ~(1 << pos);
        }
        return n;
    }
}
