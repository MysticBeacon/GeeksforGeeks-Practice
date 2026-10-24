class Solution {
    public boolean isPossible(int n, int m, String s) {
        int x = 0, y = 0;

        int minX = 0, maxX = 0;
        int minY = 0, maxY = 0;

        for (char c : s.toCharArray()) {
            switch (c) {
                case 'L':
                    y--;
                    break;

                case 'R':
                    y++;
                    break;

                case 'U':
                    x--;
                    break;

                case 'D':
                    x++;
                    break;
            }

            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);

            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);
        }

        int requiredRows = maxX - minX + 1;
        int requiredCols = maxY - minY + 1;

        return requiredRows <= n && requiredCols <= m;
    }
}