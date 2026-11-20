
class Solution {
    public int minFlips(String s) {
        int flip1 = 0;
        int flip2 = 0;

        for (int i = 0; i < s.length(); i++) {

            // Pattern 1: 010101...
            if (s.charAt(i) != (i % 2 == 0 ? '0' : '1')) {
                flip1++;
            }

            // Pattern 2: 101010...
            if (s.charAt(i) != (i % 2 == 0 ? '1' : '0')) {
                flip2++;
            }
        }

        return Math.min(flip1, flip2);
    }
}
