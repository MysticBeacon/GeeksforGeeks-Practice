class Solution {
    public int findPerimeter(int[][] mat) {
        int perimeter = 0;

        int rows = mat.length;
        int cols = mat[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (mat[i][j] == 1) {

                    // Every land cell contributes 4 sides
                    perimeter += 4;

                    // Check upper neighbor
                    if (i > 0 && mat[i - 1][j] == 1) {
                        perimeter -= 2;
                    }

                    // Check left neighbor
                    if (j > 0 && mat[i][j - 1] == 1) {
                        perimeter -= 2;
                    }
                }
            }
        }

        return perimeter;
    }
}