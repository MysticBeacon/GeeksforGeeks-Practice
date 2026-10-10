
class Solution {
    public boolean balancePan(int a, int b) {
        while (b > 0) {
            int remainder = b % a;

            if (remainder == 0) {
                b /= a;
            } else if (remainder == 1) {
                b /= a;
            } else if (remainder == a - 1) {
                b = b / a + 1;
            } else {
                return false;
            }
        }

        return true;
    }
}
