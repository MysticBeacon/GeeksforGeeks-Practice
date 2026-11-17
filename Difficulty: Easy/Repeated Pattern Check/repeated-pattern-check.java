
class Solution {
    public boolean findPattern(String s) {
        int i = 0;
        int n = s.length();

        while (i < n) {
            int countX = 0;
            int countY = 0;

            // Count consecutive x's
            while (i < n && s.charAt(i) == 'x') {
                countX++;
                i++;
            }

            // At least one x is required
            if (countX == 0) {
                return false;
            }

            // Count consecutive y's
            while (i < n && s.charAt(i) == 'y') {
                countY++;
                i++;
            }

            // Both counts must be equal
            if (countX != countY) {
                return false;
            }
        }

        return true;
    }
}
